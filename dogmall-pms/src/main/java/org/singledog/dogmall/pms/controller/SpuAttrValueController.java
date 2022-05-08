package org.singledog.dogmall.pms.controller;

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
import org.singledog.dogmall.pms.entity.SpuAttrValueEntity;
import org.singledog.dogmall.pms.service.SpuAttrValueService;

/**
 * spu属性值
 *
 * @author ZheMing Liu
 * @email dogmall@qq.com
 * @date 2022-05-03 20:38:58
 */
@Api(tags = "spu属性值 管理")
@RestController
@RequestMapping("pms/spuattrvalue")
public class SpuAttrValueController {

    @Autowired
    private SpuAttrValueService spuAttrValueService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public Response<List<SpuAttrValueEntity>> querySpuAttrValueByPage(PageRequest request) {
        return spuAttrValueService.queryPage(request);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public Response<SpuAttrValueEntity> querySpuAttrValueById(@PathVariable("id") Long id) {
        SpuAttrValueEntity entity = spuAttrValueService.getById(id);
        return ResponseFactory.getSuccessResponse(entity);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public Response save(@RequestBody SpuAttrValueEntity spuAttrValue) {
        spuAttrValueService.save(spuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public Response update(@RequestBody SpuAttrValueEntity spuAttrValue) {
        spuAttrValueService.updateById(spuAttrValue);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public Response delete(@RequestBody List<Long> ids) {
        spuAttrValueService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}
