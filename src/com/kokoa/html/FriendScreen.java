package com.kokoa.html;

import com.kokoa.domain.Profile;
import com.kokoa.domain.UserInfo;
import com.kokoa.file.FileUtil;

import java.util.List;

public class FriendScreen {

    public static void makeFriendScreenHTML(UserInfo userInfo, List<Profile> friends) {
    	System.out.println("HTML 파일을 생성합니다.");
        String uri = "references/friends.html";
        String tags = getTags(userInfo, friends);
        FileUtil.writeHtml(uri, tags);
    }

    private static String getTags(UserInfo userInfo, List<Profile> friends) {
        return Tags.start()
                .docTypeHtml()
                .openHtml("lang", "en")
                .openHead()
                .link("rel", "stylesheet", "href", "css/styles.css")
                .meta("charset", "UTF-8")
                .meta("name", "viewport", "content", "width=device-width, initial-scale=1.0")
                .title("Friends - Kokoa Clone")
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

                .openHeader("class", "screen-header")
                .h1("class", "screen-header__title", "Friends")
                .openDiv("class", "screen-header__icons")
                .openTag("span")
                .i("class", "fas fa-search fa-lg", "")
                .closeTag("span")
                .openTag("span")
                .i("class", "fas fa-music fa-lg", "")
                .closeTag("span")
                .openTag("span")
                .i("class", "fas fa-cog fa-lg", "")
                .closeTag("span")
                .closeDiv()
                .closeHeader()

                .openA("id", "friends-display-link")
                .i("class", "fas fa-info-circle", "")
                .content("Friends' Names Display")
                .i("class", "fas fa-chevron-right fa-xs", "")
                .closeA()

                .openMain("class", "friends-screen")
                .openDiv("class", "user-component")
                .openDiv("class", "user-component__column")
                .img("src", "https://avatars.githubusercontent.com/u/90658158",
                        "class", "user-component__avatar user-component__avatar--xl")
                .openDiv("class", "user-component__text")
                .h4("class", "user-component__title", "John.Jeongwoo")
                .closeDiv()
                .closeDiv()
                .div("class", "user-component__column", "")
                .closeDiv()

                .openDiv("class", "friends-screen__channel")
                .openDiv("class", "friends-screen__channel-header")
                .span("Channel")
                .i("class", "fas fa-chevron-up fa-xs", "")
                .closeDiv()
                .openDiv("class", "user-component")
                .openDiv("class", "user-component__column")
                .img("src", "https://avatars.githubusercontent.com/u/90658158",
                        "class", "user-component__avatar user-component__avatar--sm")
                .openDiv("class", "user-component__text")
                .h4("class", "user-component__title user-component__title--not-bold", "Channel")
                .closeDiv()
                .closeDiv()

                .openDiv("class", "user-component__column")
                .span("2")
                .i("class", "fas fa-chevron-right fa-xs", "")
                .closeDiv()
                .closeDiv()
                .closeDiv()
                .closeMain()

                .openNav("class", "nav")
                .openUl("class", "nav__list")
                .openLi("class", "nav__btn")
                .openA("class", "nav__link", "href", "friends.html")
                .i("class", "fas fa-user fa-2x", "")
                .closeA()
                .closeLi()
                .openLi("class", "nav__btn")
                .openA("class", "nav__link", "href", "#")
                .span("class", "nav__notification", "1")
                .i("class", "far fa-comment fa-2x", "")
                .closeA()
                .closeLi()
                .openLi("class", "nav__btn")
                .openA("class", "nav__link", "href", "#")
                .i("class", "fas fa-search fa-2x", "")
                .closeA()
                .closeLi()
                .openLi("class", "nav__btn")
                .openA("class", "nav__link", "href", "#")
                .span("class", "nav__dot", "")
                .i("class", "fas fa-ellipsis-h fa-2x", "")
                .closeA()
                .closeLi()
                .closeUl()
                .closeNav()

                .script("src", "https://kit.fontawesome.com/6478f529f2.js",
                        "crossorigin", "anonymous", "")
                .closeBody()
                .closeHtml()
                .makeTags();
    }
}
