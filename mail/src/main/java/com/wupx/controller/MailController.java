package com.wupx.controller;

import com.wupx.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

/**
 * @author wupx
 * @date 2020/08/12
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    /**
     * 发送简单邮件
     */
    @GetMapping("/sendSimpleMail")
    public void sendSimpleMail() {
        mailService.sendSimpleMail("wupx@qq.com",
                "huxy@qq.com",
                "欢迎关注微信公众号「武培轩」",
                "感谢你这么可爱，这么优秀，还来关注我，关注了就要一起成长哦~~回复【资料】领取优质资源！");
    }

    /**
     * 发送复杂邮件（文本+图片+附件）
     */
    @GetMapping("/sendMimeMail")
    public ResponseEntity<String> sendMimeMail() {
        return mailService.sendMimeMail("wupx@qq.com",
                "huxy@qq.com",
                "欢迎关注微信公众号「武培轩」",
                "<h3>感谢你这么可爱，这么优秀，还来关注我，关注了就要一起成长哦~~</h3><br>" +
                        "回复【资料】领取优质资源！<br>" +
                        "<img src='cid:logo'>");
    }

    /**
     * 发送模板邮件
     *
     * @param
     * @return
     */
    @GetMapping("/sendTemplateMail")
    public ResponseEntity<String> sendTemplateMail() {
        Context context = new Context();
        context.setVariable("username", "武培轩");
        return mailService.sendTemplateMail("wupx@qq.com",
                "huxy@qq.com",
                "欢迎关注微信公众号「武培轩」",
                context);
    }

}
