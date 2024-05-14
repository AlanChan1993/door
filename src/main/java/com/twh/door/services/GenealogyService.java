package com.twh.door.services;

import com.twh.door.entity.DTO.GenealogyDTO;
import com.twh.door.entity.DTO.QueryGenealogyEntityDTO;
import com.twh.door.entity.VO.ResultVO;

public interface GenealogyService {
    ResultVO createGenealogy(GenealogyDTO genealogyDTO);

    ResultVO selectGenealogyById(String id);

    ResultVO selectGenealogyByName(String name);

    ResultVO selectGenealogyByParentId(String parentId);

    ResultVO selectGenealogyBySonId(String sonId);

    ResultVO selectGenealogyByPartnerId(String partnerId);

    ResultVO queryGenealogyList();

    ResultVO queryGenealogyListS(QueryGenealogyEntityDTO queryGenealogyEntityDTO);

    boolean delGenealogyById(String id);


}
