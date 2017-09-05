package com.tiangou.mapper;

import com.tiangou.entity.Indent;

/**
 * <select id="selectOneIndent" parameterType="String" resultMap=
 * "BaseResultMap"> select * from indent where id=#{id} </select>
 * <insert id="insertOneIndent" parameterType="Indent"> insert into indent
 * (id,name,address,createDate,price)
 * values(#{id},#{name},#{address},#{createDate},#{price}) </insert>
 * <delete id="deleteOneIndent" parameterType="String"> delete from indent where
 * id=#{id} </delete>
 * 
 * @author Zlyj
 *
 */
public interface IndentMapper {
	public Indent selectOneIndent(String id);

	public int insertOneIndent(Indent indent);

	public int deleteOneIndent(String id);
}
