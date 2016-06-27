function load_page(page){
	var innerHtml = '<iframe id="content_frame" scrolling="no" src="' + page + '" onload="resizeIframe(this)"></iframe>';
	document.getElementById("main-content").innerHTML=innerHtml;
}

function load_page_from_iframe(page) {
	document.location.href = page;
}

function resizeIframe(object) {
    object.style.height = object.contentWindow.document.body.scrollHeight + 'px';
    object.style.width = object.contentWindow.document.body.scrollWidth + 'px';
}