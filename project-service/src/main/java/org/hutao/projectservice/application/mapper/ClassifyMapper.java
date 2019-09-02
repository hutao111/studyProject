package org.hutao.projectservice.application.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hutao.projectapi.domain.DocumentClassify;
import org.hutao.projectapi.vo.DocumentClassifyVo;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hutao
 * @since 2019-06-11
 */
@Mapper
public interface ClassifyMapper extends BaseMapper<DocumentClassify> {

    /**
     * 查询最大的code值
     *
     * @return
     */
    public Integer queryMaxCode(@Param("companyId") Long companyId, @Param("siteId") Long siteId, @Param("orgId") Long orgId);


    public List<DocumentClassifyVo> queryClassifyTree(@Param("companyId") Long companyId, @Param("siteId") Long siteId, @Param("orgId") Long orgId);

    public Integer haveChildrenClassify(@Param("classifyId") Long classifyId, @Param("companyId") Long companyId, @Param("siteId") Long siteId, @Param("orgId") Long orgId);

    List<Long> queryChildrenClassify(@Param("classifyId") Long classifyId, @Param("companyId") Long companyId, @Param("siteId") Long siteId, @Param("orgId") Long orgId);

    public  List<Map<String, Object>> getListMap();
}
