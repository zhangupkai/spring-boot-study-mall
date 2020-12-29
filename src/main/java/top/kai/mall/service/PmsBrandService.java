package top.kai.mall.service;

import top.kai.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @Description
 * @Author Kai
 * @Date 2020/12/28 8:55
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
