package com.twh.door.converter;

import com.twh.door.entity.POJO.Genealogy;
import com.twh.door.entity.VO.GenealogyVO;

import java.util.List;
import java.util.stream.Collectors;

public class GenealogyConvertTOVO {
    public GenealogyVO convert(Genealogy genealogy){
        GenealogyVO genealogyVO = new GenealogyVO();
        genealogyVO.setName(genealogy.getName());
        genealogyVO.setNickName(genealogy.getNickName());
        genealogyVO.setLiving(genealogy.getLiving());
        genealogyVO.setMotto(genealogy.getMotto());
        genealogyVO.setRemark(genealogy.getRemark());
        genealogyVO.setBornDate(genealogy.getBornDate());
        genealogyVO.setCreateTime(genealogy.getCreateTime());
        genealogyVO.setDeathDay(genealogy.getDeathDay());
        genealogyVO.setParentId(genealogy.getParentId());
        genealogyVO.setSonId(genealogy.getSonId());
        genealogyVO.setPwdId(genealogy.getPwdId());
        return genealogyVO;
    }

    public List<GenealogyVO> convertList(List<Genealogy> genealogies){
        return genealogies.stream().map(e -> convert(e)).collect(Collectors.toList());
    }

}
