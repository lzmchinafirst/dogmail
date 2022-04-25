package org.singledog.dogmail.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.singledog.dogmail.core.request.BaseRequest;
import org.singledog.dogmail.pms.entity.BrandEntity;

import java.util.List;

/**
 * 品牌
 *
 * @author Zheming Liu
 * @email dogmail@qq.com
 * @date 2022-04-23 19:43:11
 */
public interface BrandService extends IService<BrandEntity> {
    List<BrandEntity> query(BaseRequest request);
}
