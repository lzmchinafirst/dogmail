package org.singledog.dogmail.pms.controller;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.core.response.ResponseEntity;
import org.singledog.dogmail.core.response.ResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.singledog.dogmail.pms.entity.CommentReplayEntity;
import org.singledog.dogmail.pms.service.CommentReplayService;

/**
 * 商品评价回复关系
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "商品评价回复关系 管理")
@RestController
@RequestMapping("pms/commentreplay")
public class CommentReplayController {

    @Autowired
    private CommentReplayService commentReplayService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<CommentReplayEntity>> queryCommentReplayByPage(BaseRequest request) {
        List<CommentReplayEntity> commentReplayEntities = commentReplayService.query(request);
        return ResponseFactory.getSuccessResponse(commentReplayEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<CommentReplayEntity> queryCommentReplayById(@PathVariable("id") Long id) {
        CommentReplayEntity commentReplay = commentReplayService.getById(id);
        return ResponseFactory.getSuccessResponse(commentReplay);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity save(@RequestBody CommentReplayEntity commentReplay) {
        commentReplayService.save(commentReplay);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody CommentReplayEntity commentReplay) {
        commentReplayService.updateById(commentReplay);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        commentReplayService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
