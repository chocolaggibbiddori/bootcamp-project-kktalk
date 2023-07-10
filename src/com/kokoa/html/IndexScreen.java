package com.kokoa.html;

import com.kokoa.domain.UserInfo;
import com.kokoa.util.FileUtil;

public class IndexScreen {

    public static void makeIndexScreenHTML(UserInfo userInfo) {
        String uri = "references/index.html";
        String tags = getTags(userInfo);
        FileUtil.writeHtml(uri, tags);
    }

    private static String getTags(UserInfo userInfo) {
        return Tags.start()
                .docTypeHtml()
                .openHtml("lang", "en")

                .openHead()
                .link("rel", "stylesheet", "href", "css/styles.css")
                .meta("charset", "UTF-8")
                .meta("name", "viewport", "content", "width=device-width, initial-scale=1.0")
                .title("Welcome to Kokoa Clone")
                .closeHead()

                .openBody()
                .openDiv("class", "status-bar")
                .openDiv("class", "status-bar__column")
                .span("No Service")
                .i("class", "fas fa-wifi", "")
                .closeDiv()
                .openDiv("class", "status-bar__column")
                .span("18:43")
                .closeDiv()
                .openDiv("class", "status-bar__column")
                .span("110%")
                .i("class", "fas fa-battery-full fa-lg", "")
                .i("class", "fas fa-bolt", "")
                .closeDiv()
                .closeDiv()

                .openHeader("class", "welcome-header")
                .h1("class", "welcome-header__title", "Welcome to Kokoa Clone")
                .tag("p", "class", "welcome-header__text", "If you have a Kokoa Account, log in with your email or phone number.")
                .closeHeader()

                .openTag("form", "action", "friends.html", "method", "get", "id", "login-form")
                .input("name", "username", "required type", "text", "placeholder", "Email or phone number", "value", userInfo.getId())
                .input("name", "password", "required type", "password", "placeholder", "password", "value", userInfo.getPassword())
                .input("type", "submit", "value", "Log In")
                .a("href", "#", "Find Kokoa Account or Password")
                .closeTag("form")

                .script("src", "https://kit.fontawesome.com/6478f529f2.js", "crossorigin", "anonymous", "")
                .closeBody()
                .closeHtml()
                .makeTags();
    }
}
