package com.kokoa.html;

import com.kokoa.dto.ProfileDto;

import java.util.List;

public class Tags {

    private static final String OPEN_TAG_LEFT = "<";
    private static final String CLOSE_TAG_LEFT = "</";
    private static final String TAG_RIGHT_INLINE = " />\n";
    private static final String TAG_RIGHT = ">\n";
    private static final String BLANK = " ";
    private static final String EQUAL_BIG_QUOTES = "=\"";
    private static final String BIT_QUOTES = "\"";
    private static final String LINE_BREAK = "\n";

    private final StringBuilder sb = new StringBuilder();

    private Tags() {
    }

    public static Tags start() {
        return new Tags();
    }

    public String makeTags() {
        return sb.toString();
    }

    public Tags docTypeHtml() {
        openTagNoArg("!DOCTYPE html");
        return this;
    }

    public Tags content(String content) {
        sb.append(content).append(LINE_BREAK);
        return this;
    }

    public Tags tag(String tagName, String content) {
        openTagNoArg(tagName);
        sb.append(content).append(LINE_BREAK);
        closeTag(tagName);
        return this;
    }

    public Tags tag(String tagName, String prop0, String value0, String content) {
        openTagExistArg(tagName, prop0, value0);
        sb.append(content).append(LINE_BREAK);
        closeTag(tagName);
        return this;
    }

    public Tags tag(String tagName, String prop0, String value0, String prop1, String value1, String content) {
        openTagExistArg(tagName, prop0, value0, prop1, value1);
        sb.append(content).append(LINE_BREAK);
        closeTag(tagName);
        return this;
    }

    public Tags openTag(String tagName) {
        openTagNoArg(tagName);
        return this;
    }

    public Tags openTag(String tagName, String prop0, String value0) {
        openTagExistArg(tagName, prop0, value0);
        return this;
    }

    public Tags openTag(String tagName, String prop0, String value0, String prop1, String value1) {
        openTagExistArg(tagName, prop0, value0, prop1, value1);
        return this;
    }

    public Tags openTag(String tagName, String prop0, String value0, String prop1, String value1, String prop2, String value2) {
        openTagExistArg(tagName, prop0, value0, prop1, value1, prop2, value2);
        return this;
    }

    public Tags closeTag(String tagName) {
        sb.append(CLOSE_TAG_LEFT).append(tagName).append(TAG_RIGHT);
        return this;
    }

    public Tags openHtml(String prop0, String value0) {
        openTagExistArg("html", prop0, value0);
        return this;
    }

    public Tags closeHtml() {
        closeTag("html");
        return this;
    }

    public Tags openHead() {
        openTagNoArg("head");
        return this;
    }

    public Tags closeHead() {
        closeTag("head");
        return this;
    }

    public Tags openBody() {
        openTagNoArg("body");
        return this;
    }

    public Tags closeBody() {
        closeTag("body");
        return this;
    }

    public Tags div(String content) {
        tag("div", content);
        return this;
    }

    public Tags div(String prop0, String value0, String content) {
        tag("div", prop0, value0, content);
        return this;
    }

    public Tags div(String prop0, String value0, String prop1, String value1, String content) {
        tag("div", prop0, value0, prop1, value1, content);
        return this;
    }

    public Tags openDiv() {
        openTagNoArg("div");
        return this;
    }

    public Tags openDiv(String prop0, String value0) {
        openTagExistArg("div", prop0, value0);
        return this;
    }

    public Tags openDiv(String prop0, String value0, String prop1, String value1) {
        openTagExistArg("div", prop0, value0, prop1, value1);
        return this;
    }

    public Tags closeDiv() {
        closeTag("div");
        return this;
    }

    public Tags link(String prop0, String value0, String prop1, String value1) {
        openTagExistArgInline("link", prop0, value0, prop1, value1);
        return this;
    }

    public Tags meta(String prop0, String value0) {
        openTagExistArgInline("meta", prop0, value0);
        return this;
    }

    public Tags meta(String prop0, String value0, String prop1, String value1) {
        openTagExistArgInline("meta", prop0, value0, prop1, value1);
        return this;
    }

    public Tags title(String content) {
        tag("title", content);
        return this;
    }

    public Tags span(String content) {
        tag("span", content);
        return this;
    }

    public Tags span(String prop0, String value0, String content) {
        tag("span", prop0, value0, content);
        return this;
    }

    public Tags openHeader(String prop0, String value0) {
        openTagExistArg("header", prop0, value0);
        return this;
    }

    public Tags closeHeader() {
        closeTag("header");
        return this;
    }

    public Tags h1(String content) {
        tag("h1", content);
        return this;
    }

    public Tags h1(String prop0, String value0, String content) {
        tag("h1", prop0, value0, content);
        return this;
    }

    public Tags h2(String content) {
        tag("h2", content);
        return this;
    }

    public Tags h2(String prop0, String value0, String content) {
        tag("h2", prop0, value0, content);
        return this;
    }

    public Tags h3(String content) {
        tag("h3", content);
        return this;
    }

    public Tags h3(String prop0, String value0, String content) {
        tag("h3", prop0, value0, content);
        return this;
    }

    public Tags h4(String content) {
        tag("h4", content);
        return this;
    }

    public Tags h4(String prop0, String value0, String content) {
        tag("h4", prop0, value0, content);
        return this;
    }

    public Tags i(String content) {
        tag("i", content);
        return this;
    }

    public Tags i(String prop0, String value0, String content) {
        tag("i", prop0, value0, content);
        return this;
    }

    public Tags a(String content) {
        tag("a", content);
        return this;
    }

    public Tags a(String prop0, String value0, String content) {
        tag("a", prop0, value0, content);
        return this;
    }

    public Tags a(String prop0, String value0, String prop1, String value1, String content) {
        tag("a", prop0, value0, prop1, value1, content);
        return this;
    }

    public Tags openA() {
        openTagNoArg("a");
        return this;
    }

    public Tags openA(String prop0, String value0) {
        openTagExistArg("a", prop0, value0);
        return this;
    }

    public Tags openA(String prop0, String value0, String prop1, String value1) {
        openTagExistArg("a", prop0, value0, prop1, value1);
        return this;
    }

    public Tags closeA() {
        closeTag("a");
        return this;
    }

    public Tags openMain(String prop0, String value0) {
        openTagExistArg("main", prop0, value0);
        return this;
    }

    public Tags closeMain() {
        closeTag("main");
        return this;
    }

    public Tags img(String prop0, String value0) {
        openTagExistArgInline("img", prop0, value0);
        return this;
    }

    public Tags img(String prop0, String value0, String prop1, String value1) {
        openTagExistArgInline("img", prop0, value0, prop1, value1);
        return this;
    }

    public Tags openNav(String prop0, String value0) {
        openTagExistArg("nav", prop0, value0);
        return this;
    }

    public Tags closeNav() {
        closeTag("nav");
        return this;
    }

    public Tags openUl(String prop0, String value0) {
        openTagExistArg("ul", prop0, value0);
        return this;
    }

    public Tags closeUl() {
        closeTag("ul");
        return this;
    }

    public Tags openLi(String prop0, String value0) {
        openTagExistArg("li", prop0, value0);
        return this;
    }

    public Tags closeLi() {
        closeTag("li");
        return this;
    }

    public Tags script(String prop0, String value0, String content) {
        tag("script", prop0, value0, content);
        return this;
    }

    public Tags script(String prop0, String value0, String prop1, String value1, String content) {
        tag("script", prop0, value0, prop1, value1, content);
        return this;
    }

    public Tags friendsList(List<ProfileDto> friends) {
        for (ProfileDto friend : friends) {
            openDiv("class", "user-component__friends");
            openDiv("class", "user-component__column");
            img("src", friend.getImg(), "class", "user-component__avatar user-component__avatar--sm");
            openDiv("class", "user-component__text");
            h4("class", "user-component__title user-component__title--not-bold", friend.getName());
            closeDiv();
            closeDiv();
            closeDiv();
        }
        return this;
    }

    public Tags input(String prop0, String value0, String prop1, String value1) {
        openTagExistArgInline("input", prop0, value0, prop1, value1);
        return this;
    }

    public Tags input(String prop0, String value0, String prop1, String value1, String content) {
        openTagExistArg("input", prop0, value0, prop1, value1);
        sb.append(content).append(LINE_BREAK);
        closeTag("input");
        return this;
    }

    public Tags input(String prop0, String value0, String prop1, String value1, String prop2, String value2) {
        openTagExistArgInline("input", prop0, value0, prop1, value1, prop2, value2);
        return this;
    }

    public Tags input(String prop0, String value0, String prop1, String value1, String prop2, String value2, String content) {
        openTagExistArg("input", prop0, value0, prop1, value1, prop2, value2);
        sb.append(content).append(LINE_BREAK);
        closeTag("input");
        return this;
    }

    public Tags input(String prop0, String value0, String prop1, String value1, String prop2, String value2, String prop3, String value3) {
        openTagExistArgInline("input", prop0, value0, prop1, value1, prop2, value2, prop3, value3);
        return this;
    }

    private void addProperty(String prop0, String value0) {
        sb.append(prop0).append(EQUAL_BIG_QUOTES).append(value0).append(BIT_QUOTES);
    }

    private void addProperty(String prop0, String value0, String prop1, String value1) {
        addProperty(prop0, value0);
        sb.append(BLANK);
        addProperty(prop1, value1);
    }

    private void addProperty(String prop0, String value0, String prop1, String value1, String prop2, String value2) {
        addProperty(prop0, value0);
        sb.append(BLANK);
        addProperty(prop1, value1);
        sb.append(BLANK);
        addProperty(prop2, value2);
    }

    private void addProperty(String prop0, String value0, String prop1, String value1, String prop2, String value2, String prop3, String value3) {
        addProperty(prop0, value0);
        sb.append(BLANK);
        addProperty(prop1, value1);
        sb.append(BLANK);
        addProperty(prop2, value2);
        sb.append(BLANK);
        addProperty(prop3, value3);
    }

    private void openTagNoArg(String tagName) {
        sb.append(OPEN_TAG_LEFT).append(tagName).append(TAG_RIGHT);
    }

    private void openTagExistArg(String tagName) {
        sb.append(OPEN_TAG_LEFT).append(tagName).append(BLANK);
    }

    private void openTagExistArg(String tagName, String prop0, String value0) {
        openTagExistArg(tagName);
        addProperty(prop0, value0);
        sb.append(TAG_RIGHT);
    }

    private void openTagExistArg(String tagName, String prop0, String value0, String prop1, String value1) {
        openTagExistArg(tagName);
        addProperty(prop0, value0, prop1, value1);
        sb.append(TAG_RIGHT);
    }

    private void openTagExistArg(String tagName, String prop0, String value0, String prop1, String value1, String prop2, String value2) {
        openTagExistArg(tagName);
        addProperty(prop0, value0, prop1, value1, prop2, value2);
        sb.append(TAG_RIGHT);
    }

    private void openTagExistArgInline(String tagName, String prop0, String value0) {
        openTagExistArg(tagName);
        addProperty(prop0, value0);
        sb.append(TAG_RIGHT_INLINE);
    }

    private void openTagExistArgInline(String tagName, String prop0, String value0, String prop1, String value1) {
        openTagExistArg(tagName);
        addProperty(prop0, value0, prop1, value1);
        sb.append(TAG_RIGHT_INLINE);
    }

    private void openTagExistArgInline(String tagName, String prop0, String value0, String prop1, String value1, String prop2, String value2) {
        openTagExistArg(tagName);
        addProperty(prop0, value0, prop1, value1, prop2, value2);
        sb.append(TAG_RIGHT_INLINE);
    }

    private void openTagExistArgInline(String tagName, String prop0, String value0, String prop1, String value1, String prop2, String value2, String prop3, String value3) {
        openTagExistArg(tagName);
        addProperty(prop0, value0, prop1, value1, prop2, value2, prop3, value3);
        sb.append(TAG_RIGHT_INLINE);
    }
}
