

var usageLogListName = 'LP Usage Logging';

function pageOnLoad()
{
	if(window.location.href.indexOf('IsDlg=1') < 0)
	{
		EnableStatusMessage();
	}
    LPUsageLogic();
}

function LPUsageLogic()
{
	PageVisits(); //Home, public playlist
    GetInitiativePages(); //Initiative pages
    WriteEntrySearches(); //Search Page
    window.onhashchange = WriteEntrySearches; /* Attach load event for search pages */
}


function EnableStatusMessage()
{
	var context = new SP.ClientContext();
    var list = context.get_web().get_lists().getByTitle('Configuration');
    var caml = new SP.CamlQuery();
	caml.set_viewXml(
            "<View>" +
				"<Query>" +
					"<Where>" +						
						"<Eq><FieldRef Name='Key'/><Value Type='Text'>StatusEnabled</Value></Eq>" +								
					"</Where>" +
				"</Query>" +
            "</View>");
	var returnedItems = list.getItems(caml);
    context.load(returnedItems);
	context.executeQueryAsync(Function.createDelegate(this, function () { ProcessConfigurationData(returnedItems);}), Function.createDelegate(this, this.onQueryFailed) );
}

function ProcessConfigurationData(returnedItems)
{
	if(returnedItems.get_count() == 1)
	{
		var value = '';
		var listItemEnumerator = returnedItems.getEnumerator();
		while (listItemEnumerator.moveNext())
		{
			value = listItemEnumerator.get_current().get_item('Value');
		}
		if(value.toUpperCase() == 'TRUE')
		{
			var message = "<font color='#AA0000'> Maintenance is ongoing – only limited functionality of the learning portal is currently available"
            // Execute status setter only after SP.JS has been loaded
            SP.SOD.executeOrDelayUntilScriptLoaded(function () { SetStatusBar(message); }, 'sp.js');
		}
	}
}

function SetStatusBar(message) 
{
    var strStatusID = SP.UI.Status.addStatus("Information : ", message, true);
    SP.UI.Status.setStatusPriColor(strStatusID, "yellow");
}

function onQueryFailed(sender, args) 
{ 
    console.log('Request failed. ' + args.get_message() + '\n' + args.get_stackTrace());
}




function writeEntry(columnName, pageNameInitiative) {
    var context = new SP.ClientContext();
    var list = context.get_web().get_lists().getByTitle(usageLogListName);
    var caml = new SP.CamlQuery();
    if (pageNameInitiative != '') // Only for initiative pages
    {
        caml.set_viewXml(
            "<View>" +
            "<Query>" +
            "<Where>" +
            "<And>" +
            "<Eq><FieldRef Name='" + columnName + "' /><Value Type='Text'>" + pageNameInitiative + "</Value></Eq>" +
            "<And>" +
            "<Eq><FieldRef Name='Title' /><Value Type='Text'>" + _spPageContextInfo.userId + "</Value></Eq>" +
            "<Eq><FieldRef Name='LPVisitedDate'/><Value Type='DateTime'><Today /></Value></Eq>" +
            "</And>" +
            "</And>" +
            "</Where>" +
            "</Query>" +
            "</View>");
    }
    else
    {
        caml.set_viewXml(
            "<View>" +
            "<Query>" +
            "<Where>" +
            "<And>" +
            "<Eq><FieldRef Name='" + columnName + "' /><Value Type='Integer'>1</Value></Eq>" +
            "<And>" +
            "<Eq><FieldRef Name='Title' /><Value Type='Text'>" + _spPageContextInfo.userId + "</Value></Eq>" +
            "<Eq><FieldRef Name='LPVisitedDate'/><Value Type='DateTime'><Today /></Value></Eq>" +
            "</And>" +
            "</And>" +
            "</Where>" +
            "</Query>" +
            "</View>");
    }
    var returnedItems = list.getItems(caml);
    context.load(returnedItems);
    context.executeQueryAsync(Function.createDelegate(this, function () { createItem(columnName, returnedItems.get_count(), false, '', pageNameInitiative); }), Function.createDelegate(this, this.onFailedCallback));

}
function createItem(columnName, count, isSearchPage, searchTerm, pageNameInitiative)
{
    if (count == 0)
    {
        var clientContext = new SP.ClientContext.get_current();
        var list = clientContext.get_web().get_lists().getByTitle(usageLogListName);
        var itemCreateInfo = new SP.ListItemCreationInformation();
        var listItem = list.addItem(itemCreateInfo);
        listItem.set_item('Title', _spPageContextInfo.userId);

        if (pageNameInitiative != '') // Only for initiative pages
        {
            listItem.set_item(columnName, pageNameInitiative);
        }
        else
        {
            listItem.set_item(columnName, "1");
        }

        listItem.set_item('Author', 1);
        listItem.set_item('Editor', 1);

        if (isSearchPage)
        {
           listItem.set_item('LPSearchTerm', searchTerm);
        }
        listItem.update();
        clientContext.load(listItem);
        clientContext.executeQueryAsync(function () { console.log('List Item created '); }, function (sender, args) { console.log('List item creation failed. ' + args.get_message() + '\n' + args.get_stackTrace())})
    }
}
function onFailedCallback(sender, args) {
    console.log('List item creation failed. ' + args.get_message() + '\n' + args.get_stackTrace());
}

function WriteEntrySearches()
{
    var page = _spPageContextInfo.serverRequestPath;
    if (page == '/Pages/SearchView.aspx' || page == '/Pages/peopleresults.aspx')
    {
        var searchPageUrl = decodeURI(window.location.href);
        var searchIndex = searchPageUrl.indexOf(".aspx");
        var searchTerm = searchIndex != -1 ? searchPageUrl.slice(searchIndex + 5) : '';
        if (searchTerm != '')
        {
            createItem('LPPageName', 0, true, searchTerm, 'Search');
        }
    }
}

function RefreshUsageReport()
{
    alert('i am dathatri');
}

function GetInitiativePages()
{
    var context = new SP.ClientContext();
    var initiativePageLayoutUrl = '/_catalogs/masterpage/Initiative.aspx';
    var list = context.get_web().get_lists().getByTitle('Pages');
    var caml = new SP.CamlQuery();
    caml.set_viewXml(
            "<View Scope='RecursiveAll'>" +
            "<Query>" +
            "<Where>" +
                 "<Eq><FieldRef Name='PublishingPageLayout' /><Value Type='Url'>" + initiativePageLayoutUrl + "</Value></Eq>" +
            "</Where>" +
            "</Query>" +
            "</View>");
    var returnedItems = list.getItems(caml);
    context.load(returnedItems);
    context.executeQueryAsync(Function.createDelegate(this, function () { SuccessGetInitiativePages(returnedItems)}), Function.createDelegate(this, this.onFailedCallback));

}

function SuccessGetInitiativePages(returnedItems)
{
    var listItemEnumerator = returnedItems.getEnumerator();
    while (listItemEnumerator.moveNext())
    {
        var oListItem = listItemEnumerator.get_current();
        var pageName = oListItem.get_item('FileLeafRef'); // this value comes as pageName.aspx
        var relPageUrl = oListItem.get_item('FileDirRef') + '/'+ pageName;
        var page = _spPageContextInfo.serverRequestPath;
        if (page == relPageUrl)
        {
            writeEntry('LPPageName', pageName);
        }
       
    }
   
}



function PageVisits()
{
    var page = _spPageContextInfo.serverRequestPath.toUpperCase();

    writeEntry('LPPageName', 'Site'); //Site Visit


    if (page == '/PAGES/HOMEPAGE.ASPX')
    {
        writeEntry('LPPageName', 'Home'); //Home page visit
    }

    if (page == '/PAGES/PUBLICPLAYLIST.ASPX')
    {
        writeEntry('LPPageName', 'PublicPlayList'); //Public playlist visit
    }
}

//Site
//Home
//PublicPlayList
//Search