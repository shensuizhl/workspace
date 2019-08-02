const ip = "http://192.168.1.109:8080/demo";

function post(setting) {
  setting.type = "post";
  request(setting);
}

function list(setting) {
  setting.type = "get";
  request(setting)
}

function remove(setting) {
  setting.type = "delete";
  request(setting)
}

function put(setting) {
  setting.type = "put";
  request(setting)
}

function request(setting) {
  // 默认dataType = 'json';
  if (!setting.hasOwnProperty('dataType')) {
    setting.dataType = "json";
  }

  if (!setting.hasOwnProperty("headers")) {
    setting.headers = new Object();
  }

  // 如果数据是string格式，默认发送数据是json格式
  if (setting.hasOwnProperty("data")) {
    if (typeof setting.data == "string") {
      setting.headers["Content-type"] = "application/json;charset=utf-8";
    }
  }
  
  // 补上url的context
  setting.url = ip + setting.url;
  // 如果sessionStorage存在authorization
  // 则添加请求头Authorization
  var authorization = sessionStorage.getItem("authorization");
  if (authorization != null) {
    if (!setting.hasOwnProperty('headers')) {
      setting.headers = new Object();
    }
    setting.headers["Authorization"] = authorization;
  }
  $.ajax(setting);
}
