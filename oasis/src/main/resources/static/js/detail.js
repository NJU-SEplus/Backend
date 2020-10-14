$(function () {
    var doi = "";
    $("body").delegate("#result a","click",function () {
        doi = $(this).parent().siblings(".doi").text().substring(5);
        $("body > nav ~ *").remove();
        var URL = "/document/DOI?doi="+doi;
        getRequest(
            URL,
            function (res) {
                displayDetail(res.content[0]);
        })
    })


    function displayDetail(info) {
        var publisher = defaultVal(info.publisher);
        var ieeeterm = defaultVal(info.ieeeterm);
        var keywords = defaultVal(info.keyWords);
        var refCount = info.referenceCount?info.referenceCount:0;
        var year = info.publicationYear?info.publicationYear:"unknown";
        var publicationTitle = defaultVal(info.publicationTitle);


        var contentStr = "<div id=\"detail\"><div class=\"container\"><div class=\"title\"><h3><a href=\"" +info.pdflink+"\">"+info.title+"</a></h3>"
        +"<div class=\"from\"><span>publisher: "+publisher+"</span><span>refenrenceCount: "+refCount+"</span></div></div><hr />"
        +"<div class=\"content-info\"><div class=\"alert alert-info\" role=\"alert\"><div><ul class=\"nav nav-tabs\" role=\"tablist\">"
        +"<li role=\"presentation\" class=\"active\"><a aria-controls=\"home\" role=\"tab\" data-toggle=\"tab\">Abstract</a></li></ul>"
        +"<div class=\"tab-content\"><div role=\"tabpanel\" class=\"tab-pane active\" id=\"home\">"+info.abstract+"</div>"
        +"</div></div><hr /><div><p><span class='d-head'>IEEEterm: </span>"+ieeeterm+"</p></div>"+"<div><p><span class='d-head'>Keywords: </span>"+keywords+"</p></div></div></div><hr />";
//abstract就绪

        var detailStr = "<div class=\"detail-info\"><div class=\"alert alert-warning\" role=\"alert\"><div><p><span class='d-head'>Author: </span>"+info.author+"</p></div><div>"
        +"<p><span class='d-head'>Affiliation: </span>"+info.affiliation+"</p></div><div><p><span class='d-head'>DOI: </span>"
        +info.doi+"</p></div><div><p><span class='d-head'>Year: </span>"+year+"</p></div><div><p><span class='d-head'>Publication: </span>"
        +publicationTitle+"</p></div></div></div></div></div>";



        $("body").append(contentStr+detailStr);

    }

    function defaultVal(str) {
        if(!str){return "None";}
        return str;
    }
})