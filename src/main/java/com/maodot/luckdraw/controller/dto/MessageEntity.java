package com.maodot.luckdraw.controller.dto;

import java.io.Serializable;

/**
 * 响应的消息实体，使用例子如下：
 *
 * @FormToken(produce = true)
 * @ResponseBody
 * @RequestMapping(value = "/create/test", method = RequestMethod.GET) public
 *                       Object test(HttpServletRequest request) throws
 *                       JsonProcessingException { Object map = new HashMap<>();
 *                       map.put("redirect", "http://www.baidu.com/"); return
 *                       new
 *                       MessageEntity.Builder(request).code(MessageCodeEnum.ALREADY_EXISTS).
 *                       msg("账户已存在").content(map).success(false).create(); }
 *                       <p/>
 *                       构造对此对象时，消息不传时会默认初始化一些值。以下键值对左边表示属性，右边表示默认值：requestId=null,
 *                       msg=null, seccuess=false , code=0,
 *                       content=null，而resubmitToken已内置在构造器中，无需担忧默认为空。通常该值是从
 *                       SESSION 中取，为了防止TOKEN 重复提交功能生效，
 *                       请勿自定义resubmitToken值。正确的做法是传入request
 */
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 5165069341805388402L;

    private final String msg; // 消息
    private final boolean success; // 操作成功与否
    private final int bizCode; // 业务错误码
    private final int code; // 状态码
    private final Object content; // 内容主体

    /**
     * 请选构造 MessageEntity.Builder 对象
     *
     * @param builder
     */
    public MessageEntity(Builder builder) {
        this.msg = builder.msg;
        this.success = builder.success;
        this.code = builder.code;
        this.content = builder.content;
        this.bizCode = builder.bizCode;
    }

    public int getBizCode() {
        return bizCode;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public Object getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MessageEntity{" + ", msg='" + msg + '\'' + ", success=" + success + ", code=" + code + ", bizCode="
                + bizCode + ", content=" + content + '}';
    }

    public static class Builder {
        private String msg; // 消息
        private boolean success; // 操作成功与否
        private int code; // 状态码
        private int bizCode; // 业务码
        private Object content; // 内容主体

        /**
         * 消息，需要解决国际化问题
         *
         * @param msg
         * @return
         */
        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        /**
         * 是否成功
         *
         * @param success
         * @return
         */
        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder code(int code) {
            this.code = code;
            return this;
        }

        public Builder bizCode(int bizCode) {
            this.bizCode = bizCode;
            return this;
        }

        /**
         * 消息主体，根据前端需求构造
         *
         * @param content
         * @return
         */
        public Builder content(Object content) {
            this.content = content;
            return this;
        }

        public MessageEntity create() {
            return new MessageEntity(this);
        }
    }
}