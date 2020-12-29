package top.kai.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.kai.mall.common.api.CommonResult;
import top.kai.mall.mbg.model.PmsBrand;
import top.kai.mall.service.PmsBrandService;

import java.util.List;

/**
 * @Description 品牌管理Controller
 * @Author Kai
 * @Date 2020/12/26 21:27
 */
@Api(tags = "商品品牌管理")
@RestController
@RequestMapping("/brand")
@Slf4j
public class PmsBrandController {

    @Autowired
    PmsBrandService brandService;

    @ApiOperation("获取所有品牌列表")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getBrandList() {
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @PostMapping("/create")
    public CommonResult<?> createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult<?> commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            log.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id品牌信息")
    @PostMapping("/update/{id}")
    public CommonResult<?> updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        CommonResult<?> commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            log.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @PostMapping("/delete/{id}")
    public CommonResult<?> deleteBrand(@PathVariable("id") Long id) {
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            log.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        } else {
            log.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("获取指定id的品牌详情")
    @GetMapping("/{id}")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }
}
