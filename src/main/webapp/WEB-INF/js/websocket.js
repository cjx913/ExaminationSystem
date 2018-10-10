function getWebsocket(onopen,onmessage,onclose,onerror) {
    var ws;
    var url = "";
    var host = window.location.host;//主机名+端口号
    var pathName = window.location.pathname;//路径名
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);//带”/“的项目名
    if ('WebSocket' in window) {
        url = 'ws://' + host + projectName + '/myWebscoket';
        ws = new WebSocket(url);
    } else {
        url = projectName + 'http://'+host+projectName+'/sockjs/myWebscoket';
        ws = new SockJS(url);
    }
    if (onopen == null) {
        ws.onopen = function () {
            console.info("Websocket Open:" + url);
        }
    } else {
        ws.onopen = onopen;
    }

    if (onmessage == null) {
        ws.onmessage = function () {
            console.info("Websocket Message:" + url);
        }
    } else {
        ws.onmessage = onmessage;
    }

    if (onclose == null) {
        ws.onclose = function () {
            console.info("Websocket Close:" + url);
        }
    } else {
        ws.onclose = onclose;
    }

    if (onerror == null) {
        ws.onclose = function () {
            console.info("Websocket Error:" + url);
        }
    } else {
        ws.onerror = onerror;
    }

    return ws;
}