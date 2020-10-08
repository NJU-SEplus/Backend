
function showFieldList(list) {
    console.log(list);
    var itemList = [];
    $("nav ~ *").remove();
    $('body').append("<div class='blank-div'></div>");
    list.forEach(function (data) {
        var itemStr = "<div class=\"container field-container\"><div class=\"item\"><h3><a href=\"#\" id=\""+data.id+
            "\">"+data.name+"</a></h3><div><span class=\"heat-head\">Heat:"+data.heat+"</span></div>"+
            "<div><span class=\"card-head\">Author count in this field: </span><span class=\"pub-count\">"+data.authorCount+
            "</span></div><div><span class=\"card-head\">Paper count in this field: </span><span class=\"pub-count\">"+
            data.docCount+"</span></div></div></div>";
        $('body').append(itemStr);
    })

    $('body').delegate(".field-container a",'click',function (event) {
        event = event || window.event;
        var fieldId = event.target.id;
        showFieldDetail(fieldId);
    })
}

function showFieldDetail(id) {
    $('nav ~ *').remove();
    $('body').append("<div id='charts8'></div>");
    getRequest(
        "/Portrait/Direction/id/"+id,
        function (res) {
            drawDirectionAuthorChart(res);
        }
    )
}