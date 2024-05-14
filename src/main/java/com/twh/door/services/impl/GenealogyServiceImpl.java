package com.twh.door.services.impl;

import com.twh.door.converter.GenealogyConvertTOVO;
import com.twh.door.converter.GenealogyToGenealogyDTO;
import com.twh.door.entity.DTO.GenealogyDTO;
import com.twh.door.entity.DTO.QueryGenealogyEntityDTO;
import com.twh.door.entity.POJO.Genealogy;
import com.twh.door.entity.VO.ResultVO;
import com.twh.door.enums.ResultEnums;
import com.twh.door.exception.DoorException;
import com.twh.door.mapper.GenealogyMapper;
import com.twh.door.services.GenealogyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GenealogyServiceImpl implements GenealogyService {
    @Autowired
    private GenealogyMapper mapper;

    @Override
    public ResultVO createGenealogy(GenealogyDTO genealogyDTO) {
        ResultVO resultVO = new ResultVO();
        Genealogy genealogy = new GenealogyToGenealogyDTO().convert(genealogyDTO);
        boolean a = false;
        try {
            a = mapper.createGenealogy(genealogy);
            resultVO.setSuccess(a);
            resultVO.setMsg(ResultEnums.CREATE_SUCCESS.getMsg());
            resultVO.setDetail(new GenealogyConvertTOVO().convert(genealogy));
            log.info("【GenealogyServiceImpl.createGenealogy】ex=:{}", resultVO);
        } catch (DoorException ex) {
            resultVO.setSuccess(a);
            resultVO.setMsg(ResultEnums.CREATE_FAIL.getMsg());
            log.info("【GenealogyServiceImpl.createGenealogy】ex=:{}", resultVO);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectGenealogyById(String id) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(id)) {
            Genealogy genealogy = new Genealogy();

            genealogy = mapper.selectGenealogyById(Integer.valueOf(id));
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(genealogy);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectGenealogyByName(String name) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(name)) {
            List<Genealogy> list = new ArrayList<>();

            list = mapper.selectGenealogyByName(name);
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(list);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectGenealogyByParentId(String parentId) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(parentId)) {
            List<Genealogy> list = new ArrayList<>();
            list = mapper.selectGenealogyByParentId(Integer.valueOf(parentId));
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(list);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectGenealogyBySonId(String sonId) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(sonId)) {
            List<Genealogy> list = new ArrayList<>();
            list = mapper.selectGenealogyBySonId(Integer.valueOf(sonId));
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(list);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectGenealogyByPartnerId(String partnerId) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(partnerId)) {
            List<Genealogy> list = new ArrayList<>();
            list = mapper.selectGenealogyByPartnerId(Integer.valueOf(partnerId));
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(list);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO selectFamilyById(String pwdId) {
        ResultVO resultVO = new ResultVO();
        if (StringUtils.isNotEmpty(pwdId)) {
            List<Genealogy> list = new ArrayList<>();
            list = mapper.selectFamilyById(Integer.valueOf(pwdId));
            resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
            resultVO.setDetail(list);
            resultVO.setSuccess(true);
        }else {
            resultVO.setMsg(ResultEnums.SYS_ERROR.getMsg());
            resultVO.setDetail(null);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @Override
    public ResultVO queryGenealogyList() {
        List<Genealogy> list = mapper.queryGenealogyList();
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setDetail(list);
        resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
        return resultVO;
    }

    @Override
    public ResultVO queryGenealogyListS(QueryGenealogyEntityDTO queryGenealogyEntityDTO) {
        ResultVO resultVO = new ResultVO();
        List<Genealogy> list = mapper.queryGenealogyListS(queryGenealogyEntityDTO);
        resultVO.setSuccess(true);
        resultVO.setDetail(list);
        resultVO.setMsg(ResultEnums.SELECT_SUCCESS.getMsg());
        return resultVO;
    }

    @Override
    public boolean delGenealogyById(String id) {
        return mapper.delGenealogyById(id
        );
    }
}
