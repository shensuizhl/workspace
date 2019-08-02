$.ajax({
   url: "http://192.168.1.109:8080/demo/PlotController/terminationBarChart.do",//json�ļ�λ��
   type: "GET",//����ʽΪget
   dataType: "json", //�������ݸ�ʽΪjson
   success: function(data) {//����ɹ���ɺ�Ҫִ�еķ��� 
   console.log(data.data[0]);
   var x=[],y= [];
   for (i = 0; i < data.data.length; i++) { 
	x[i]=data.data[i].label;
	y[i]=data.data[i].value;
 }
 //console.log(x);
   trace1 = {
  x: x, 
  y: y, 
  type: 'bar',
  name: 'department'
};
data1 = [trace1];
layout = {title: 'January 2013 Sales Report'};
Plotly.plot('plotly-div', {
  data: data1,
  layout: layout
});
       //eachѭ�� ʹ��$.each�����������ص�����date
       // $.each(data.first, function(i, item) {
            // var str = '<div>����:' + item.name + '�Ա�' + item.sex + '</div>';
            // document.write(str);
       // })
   }
})