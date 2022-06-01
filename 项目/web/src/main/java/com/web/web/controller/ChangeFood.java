package com.web.web.controller;

import com.web.web.common.result;
import com.web.web.entity.Food;
import com.web.web.mapper.changefood;
import com.web.web.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/changefood")
public class ChangeFood {

    @Autowired
    private changefood changefood;

    @Autowired
    private FoodService foodService;

    //新增和修改
    @PostMapping
    public result save(@RequestBody Food food){
       if (foodService.save(food)==1){
           return result.success("修改商品信息成功");
       }
       else {
           return result.error("无效商品id");
       }

    }

    //删除
    @DeleteMapping("/{food_id}")
    public result delete(@PathVariable Integer food_id){
        if(changefood.delete(food_id)==1){
            return result.success("删除商品成功");
        }
        else {
            return result.error("无效商品id");
        }
    }
}
