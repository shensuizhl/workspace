/* This file is currently associated to an HTML file of the same name and is drawing content from it.  Until the files are disassociated, you will not be able to move, delete, rename, or make any other changes to this file. */

function DisplayTemplate_79b028d6ed604e8bbb98b1fb8e4af5af(ctx) {
  var ms_outHtml=[];
  var cachePreviousTemplateData = ctx['DisplayTemplateData'];
  ctx['DisplayTemplateData'] = new Object();
  DisplayTemplate_79b028d6ed604e8bbb98b1fb8e4af5af.DisplayTemplateData = ctx['DisplayTemplateData'];

  ctx['DisplayTemplateData']['TemplateUrl']='~sitecollection\u002f_catalogs\u002fmasterpage\u002fDisplay Templates\u002fSearch\u002fControl_SearchBox.js';
  ctx['DisplayTemplateData']['TemplateType']='Control';
  ctx['DisplayTemplateData']['TargetControlType']=['SearchBox'];
  this.DisplayTemplateData = ctx['DisplayTemplateData'];

ms_outHtml.push('',''
); 
        var showQuerySuggestions = ctx.ClientControl.get_showQuerySuggestions();
        var showNavigation = ctx.ClientControl.get_showNavigation();


 
         var language = navigator.language === "de" || navigator.language === "de-DE" || navigator.language === "de-de"
            || navigator.language === "de-at" || navigator.language === "de-li" || navigator.language === "de-lu" || navigator.language === "de-ch"
            || navigator.language === "de-AT" || navigator.language === "de-LI" || navigator.language === "de-LU" || navigator.language === "de-CH"
            ? 1031 : 1033;
         var prompt = language === 1031 ? "Lerninhalte suchen" : "Search for Learning Content";

        if ($isNull(prompt))
        {
            prompt = Srch.Res.sb_Prompt;
        }

        var inputClass = "ms-textLarge ms-srch-sbLarge-fullWidth";
        if(showNavigation){
            inputClass = "ms-textLarge ms-srch-sbLarge-navWidth";
        }

        var searchBoxDivId = ctx.ClientControl.get_id() + "_sboxdiv";
        var searchBoxId = ctx.ClientControl.get_id() + "_sbox";
        var navButtonId = ctx.ClientControl.get_id() + "_NavButton";
        var suggestionsListId = ctx.ClientControl.get_id() + "_AutoCompList"; 
        var navListId = ctx.ClientControl.get_id() + "_NavDropdownList";
        var searchBoxLinkId = ctx.ClientControl.get_id() + "_SearchLink";
        var searchBoxProgressClass = "ms-srch-sbprogressLarge";
        var searchBoxPromptClass = "ms-srch-sb-prompt ms-helperText";

        ctx.OnPostRender = function(rCtx) {
            ctx.ClientControl.activate(
                prompt, 
                searchBoxId, 
                searchBoxDivId, 
                navButtonId, 
                suggestionsListId, 
                navListId, 
                searchBoxLinkId, 
                searchBoxProgressClass,
                searchBoxPromptClass);            
        }                      
ms_outHtml.push(''
,'        <div id="SearchBox" name="Control" class="ms-floatLeft">'
,'            <div class="ms-srch-sbLarge ms-srch-sb-border" id="', $htmlEncode(searchBoxDivId) ,'">'
,'                <input type="text" value="', $htmlEncode(ctx.ClientControl.get_currentTerm()) ,'" maxlength="2048" accessKey="', $htmlEncode(Srch.Res.sb_AccessKey) ,'" title="', $htmlEncode(prompt) ,'" id="', $htmlEncode(searchBoxId) ,'" autocomplete="off" autocorrect="off" onkeypress="if (Srch.U.isEnterKey(String.fromCharCode(event.keyCode))) { $getClientControl(this).search(this.value);return Srch.U.cancelEvent(event); }" onkeydown="var ctl = $getClientControl(this);ctl.activateDefaultQuerySuggestionBehavior();" onfocus="var ctl = $getClientControl(this);ctl.hidePrompt();ctl.setBorder(true);" onblur="var ctl = $getClientControl(this);ctl.showPrompt();ctl.setBorder(false);" class="', inputClass ,'" /> '
); 
                var imagesUrl = GetThemedImageUrl('searchresultui.png');
                if (showNavigation) { 
ms_outHtml.push(''
,'                    <a class="ms-srch-sb-navLink" title="', $htmlEncode(Srch.Res.sb_GoNav) ,'" id="', $htmlEncode(navButtonId) ,'" onclick="$getClientControl(this).activateDefaultNavigationBehavior();return Srch.U.cancelEvent(event);" href="javascript: {}">'
,'                        <img src="', $urlHtmlEncode(imagesUrl) ,'" class="ms-srch-sbLarge-navImg" id="navImg" alt="', $htmlEncode(Srch.Res.sb_GoNav) ,'" />'
,'                    </a>'
); 
                }
ms_outHtml.push(''
,'				<a title="', $htmlEncode(Srch.Res.sb_GoSearch) ,'" class="ms-srch-sb-searchLink" id="', $htmlEncode(searchBoxLinkId) ,'" onclick="$getClientControl(this).search($get(\'', $scriptEncode(searchBoxId) ,'\').value);" href="javascript: {}">'
,'					<img src="', $urlHtmlEncode(imagesUrl) ,'" class="ms-srch-sbLarge-searchImg" id="searchImg" alt="', $htmlEncode(Srch.Res.sb_GoSearch) ,'" />'
,'                </a>'
); 
            if (showQuerySuggestions) { 
ms_outHtml.push(''
,'                <div class="ms-qSuggest-container ms-shadow" id="AutoCompContainer">'
,'                    <div id="', $htmlEncode(suggestionsListId) ,'"></div>'
,'                </div>'
); 
            } 

            if (showNavigation) { 
ms_outHtml.push(''
,'                <div class="ms-qSuggest-container ms-shadow" id="NavDropdownListContainer">'
,'                    <div id="', $htmlEncode(navListId) ,'"></div>'
,'                </div>'
); 
            }

ms_outHtml.push(''
,'	</div>'
,'        </div>'
,'		<div id="SearchOptions">'
);
			 if (ctx.ClientControl.get_showAdvancedLink()) {
					var advancedUrl = ctx.ClientControl.get_advancedSearchPageAddress();
					if(!$isEmptyString(advancedUrl)){ 
ms_outHtml.push(''
,'						<div class="ms-srch-sbLarge-link"><a id="AdvancedLink" href="', $urlHtmlEncode(advancedUrl) ,'">', $htmlEncode(Srch.Res.sb_AdvancedLink) ,'</a></div>'
); 
					}
				}
				if (ctx.ClientControl.get_showPreferencesLink()) {
					var preferencesUrl = ctx.ScriptApplicationManager.get_preferencesUrl();
					if(!$isEmptyString(preferencesUrl)){ 
ms_outHtml.push(''
,'						<div class="ms-srch-sbLarge-link"><a id="PreferencesLink" href="', $urlHtmlEncode(preferencesUrl) ,'">', $htmlEncode(Srch.Res.sb_PreferencesLink) ,'</a></div>'
); 
					}
				} 
ms_outHtml.push(''
,'		</div>'
,'		<div id="SearchBoxRowCount"> '
,'		'
,'		</div>'
,'		'
,'    '
);

  ctx['DisplayTemplateData'] = cachePreviousTemplateData;
  return ms_outHtml.join('');
}
function RegisterTemplate_79b028d6ed604e8bbb98b1fb8e4af5af() {

if ("undefined" != typeof (Srch) &&"undefined" != typeof (Srch.U) &&typeof(Srch.U.registerRenderTemplateByName) == "function") {
  Srch.U.registerRenderTemplateByName("Control_SearchBox", DisplayTemplate_79b028d6ed604e8bbb98b1fb8e4af5af);
}

if ("undefined" != typeof (Srch) &&"undefined" != typeof (Srch.U) &&typeof(Srch.U.registerRenderTemplateByName) == "function") {
  Srch.U.registerRenderTemplateByName("~sitecollection\u002f_catalogs\u002fmasterpage\u002fDisplay Templates\u002fSearch\u002fControl_SearchBox.js", DisplayTemplate_79b028d6ed604e8bbb98b1fb8e4af5af);
}

}
RegisterTemplate_79b028d6ed604e8bbb98b1fb8e4af5af();
if (typeof(RegisterModuleInit) == "function" && typeof(Srch.U.replaceUrlTokens) == "function") {
  RegisterModuleInit(Srch.U.replaceUrlTokens("~sitecollection\u002f_catalogs\u002fmasterpage\u002fDisplay Templates\u002fSearch\u002fControl_SearchBox.js"), RegisterTemplate_79b028d6ed604e8bbb98b1fb8e4af5af);
}