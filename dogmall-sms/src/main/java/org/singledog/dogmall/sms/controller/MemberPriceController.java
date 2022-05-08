package org.singledog.dogmall.sms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmall.core.request.PageRequest;
import org.singledog.dogmall.core.response.Response;
import org.singledog.dogmall.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.singledog.dogmall.sms.entity.MemberPriceEntity;
import org.singledog.dogmall.sms.service.MemberPriceService;

/**
 * 商品会员价格
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 23:49:56
 */
@Api(tags = "商品会员价格 管理")
@RestController
@RequestMapping("sms/memberprice")
public class MemberPriceController {

    @Autowired
    private MemberPriceService memberPriceService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<MemberPriceEntity>> queryMemberPriceByPage(PageRequest request) {
        return memberPriceService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<MemberPriceEntity> queryMemberPriceById(@PathVariable("id") Long id) {
        MemberPriceEntity entity = memberPriceService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.save(memberPrice);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody MemberPriceEntity memberPrice) {
        memberPriceService.updateById(memberPrice);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        memberPriceService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
