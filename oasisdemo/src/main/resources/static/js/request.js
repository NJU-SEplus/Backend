document.onkeydown = function(event){
    event = event || window.event;

}

function getRequest(url,onSuccess,onError) {
    $.ajax({
        type:"GET",
        url:url,
        async:true,
        success:onSuccess,
        error:onError
    });
}

function postRequest(url,data,onSuccess,onError) {
    $.ajax({
       type: "POST",
       url:url,
       async:true,
       data:JSON.stringify(data),
       contentType:'application/json',
       processData:false,
       success: onSuccess,
       error: onError
    });
}

function resultStr(title, authorName, affiliation, doi, keyword,year) {
    if(!keyword){keyword="<b>None</b>";}
    // if(!conTerm){conTerm="<b>None</b>";}
    // if(!nonConTerm){nonConTerm="<b>None</b>";}
    // if(!ieeeTerm){ieeeTerm="<b>None</b>";}
    var str = "<div class=\"result-content\">" +
        "<h5><a href=\"javascript:;\">" + title + "</a></h5>" +
        "<p><span>Author:  </span>  " + authorName + "</p>" +
        "<p><span>Affiliation:  </span> " + affiliation + "</p>" +
        "<p class='doi'><span>DOI:</span> " + doi + "</p>" +
        "<p><span>Keryword:  </span>" + keyword + "</p>" +
        // "<p id=\"con-term\"><span>ICterm:  </span>" + conTerm + "</p>" +
        // "<p id=\"non-term\"><span>INCterm:  </span>" + nonConTerm + "</p>" +
        // "<p id=\"ieee-term\"><span>IEEEterm:  </span>" + ieeeTerm + "</p>" +
        "<p id=\"year\"><span>PublicationYear:  </span>"+ year + "</p>"
        +"</div>";
    // if(keyword){
    //     str += "<p id=\"keywords\"><span>Keywords:</span>"+keyword+"</p>";
    // }
    // if(conTerm){
    //     str +="<p id=\"conTerm\"><span"
    // }
    return str;
}

function spaceReplace(str) {
    return str.replace(/\s+/g,"%20");
}

function questionReplace(str){
	return str.replace(/[?]/g,"");
}

function slashReplace(str) {
    return str.replace(/\//g,"%2F");
}
