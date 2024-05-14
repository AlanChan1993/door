package com.twh.door.controller;

import com.twh.door.entity.DTO.GenealogyDTO;
import com.twh.door.entity.DTO.QueryGenealogyEntityDTO;
import com.twh.door.entity.POJO.Genealogy;
import com.twh.door.entity.VO.ResultVO;
import com.twh.door.enums.ResultEnums;
import com.twh.door.exception.DoorException;
import com.twh.door.services.GenealogyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/genealogy")
public class GenealogyController {

    @Autowired
    private GenealogyService service;

    @PostMapping("create")
    public ResultVO create(@RequestBody @Valid GenealogyDTO genealogyDTO, BindingResult bindingResult){
        if (ObjectUtils.isEmpty(genealogyDTO)) {
            throw new DoorException(ResultEnums.PARM_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        return service.createGenealogy(genealogyDTO);
    }

    @ResponseBody
    @GetMapping("selectById")
    public ResultVO selectById(@RequestParam("gId") String id){
        if (StringUtils.isEmpty(id)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectGenealogyById(id);
    }

    @ResponseBody
    @GetMapping("selectByParentId")
    public ResultVO selectGenealogyByParentId(@RequestParam("parent") String parentId){
        if (StringUtils.isEmpty(parentId)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectGenealogyByParentId(parentId);
    }

    @ResponseBody
    @GetMapping("selectBySonId")
    public ResultVO selectGenealogyBySonId(@RequestParam("son") String sonId){
        if (StringUtils.isEmpty(sonId)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectGenealogyBySonId(sonId);
    }

    @ResponseBody
    @GetMapping("selectByPartnerId")
    public ResultVO selectGenealogyByPartnerId(@RequestParam("partner") String partnerId){
        if (StringUtils.isEmpty(partnerId)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectGenealogyByPartnerId(partnerId);
    }

    @ResponseBody
    @GetMapping("selectFamilyById")
    public ResultVO selectFamilyById(@RequestParam("pwd") String pwdId){
        if (StringUtils.isEmpty(pwdId)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectFamilyById(pwdId);
    }


    @ResponseBody
    @GetMapping("selectByName")
    public ResultVO selectByName(@RequestParam("gName") String name){
        if (StringUtils.isEmpty(name)) {
            throw new DoorException(ResultEnums.SYS_ERROR.getMsg());
        }
        return service.selectGenealogyByName(name);
    }

    @ResponseBody
    @GetMapping("queryList")
    public ResultVO queryGenealogyList(){
        return service.queryGenealogyList();
    }

    @ResponseBody
    @RequestMapping("queryListByS")
    public ResultVO queryGenealogyListS(@RequestBody @Valid QueryGenealogyEntityDTO queryGenealogyEntityDTO,
                                        BindingResult bindingResult){
        if (ObjectUtils.isEmpty(queryGenealogyEntityDTO)) {
            throw new DoorException(ResultEnums.PARM_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        return service.queryGenealogyListS(queryGenealogyEntityDTO);
    }

    @DeleteMapping("delById")
    public ResultVO delById(@RequestParam("dId") String dId){
        return service.delGenealogyById(dId);
    }

}
