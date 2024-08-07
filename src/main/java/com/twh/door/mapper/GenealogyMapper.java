package com.twh.door.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twh.door.entity.DTO.QueryGenealogyEntityDTO;
import com.twh.door.entity.POJO.Genealogy;
import com.twh.door.entity.VO.ResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public interface GenealogyMapper {
    boolean createGenealogy(Genealogy genealogy);

    Genealogy selectGenealogyById(Integer id);

    List<Genealogy> selectGenealogyByName(String name);

    List<Genealogy> selectGenealogyByParentId(Integer parentId);

    List<Genealogy> selectGenealogyBySonId(Integer sonId);

    List<Genealogy> selectGenealogyByPartnerId(Integer partnerId);

    List<Genealogy> selectFamilyById(Integer pwdId);

    List<Genealogy> queryGenealogyList();

    List<Genealogy> queryGenealogyListS(QueryGenealogyEntityDTO queryGenealogyEntityDTO);

    boolean delGenealogyById(Integer id);

    Page<Genealogy> queryGenealogyListPage(IPage<?> page, @Param("dto") QueryGenealogyEntityDTO queryGenealogyEntityDTO);

}
