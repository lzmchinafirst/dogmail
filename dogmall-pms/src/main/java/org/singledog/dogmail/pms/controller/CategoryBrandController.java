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

import org.singledog.dogmail.pms.entity.CategoryBrandEntity;
import org.singledog.dogmail.pms.service.CategoryBrandService;

/**
 * 品牌分类关联
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
@Api(tags = "品牌分类关联 管理")
@RestController
@RequestMapping("pms/categorybrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService;

    /**
     * 列表
     */
    @GetMapping
    @ApiOperation("分页查询")
    public ResponseEntity<List<CategoryBrandEntity>> queryCategoryBrandByPage(BaseRequest request) {
        List<CategoryBrandEntity> categoryBrandEntities = categoryBrandService.query(request);
        return ResponseFactory.getSuccessResponse(categoryBrandEntities);
    }


    /**
     * 信息
     */
    @GetMapping("{id}")
    @ApiOperation("详情查询")
    public ResponseEntity<CategoryBrandEntity> queryCategoryBrandById(@PathVariable("id") Long id) {
        CategoryBrandEntity categoryBrand = categoryBrandService.getById(id);
        return ResponseFactory.getSuccessResponse(categoryBrand);
    }

    /**
     * 保存
     */
    @PostMapping
    @ApiOperation("保存")
    public ResponseEntity<Object> save(@RequestBody CategoryBrandEntity categoryBrand) {
        categoryBrandService.save(categoryBrand);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation("修改")
    public ResponseEntity update(@RequestBody CategoryBrandEntity categoryBrand) {
        categoryBrandService.updateById(categoryBrand);
        return ResponseFactory.getSuccessResponse();
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    @ApiOperation("删除")
    public ResponseEntity delete(@RequestBody List<Long> ids) {
        categoryBrandService.removeByIds(ids);
        return ResponseFactory.getSuccessResponse();
    }

}