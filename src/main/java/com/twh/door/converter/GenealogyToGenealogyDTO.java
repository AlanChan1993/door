package com.twh.door.converter;

import com.twh.door.entity.DTO.GenealogyDTO;
import com.twh.door.entity.POJO.Genealogy;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenealogyToGenealogyDTO {
    public Genealogy convert(GenealogyDTO genealogyDTO) {
        Genealogy genealogy = new Genealogy();
        BeanUtils.copyProperties(genealogyDTO, genealogy);
        return genealogy;
    }

    public List<Genealogy> convertList(List<GenealogyDTO> genealogyDTOS) {
        List<Genealogy> genealogies = genealogyDTOS.stream().map(e -> convert(e)).collect(Collectors.toList());
        return genealogies;
    }

}
