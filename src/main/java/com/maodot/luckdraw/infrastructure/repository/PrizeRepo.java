package com.maodot.luckdraw.infrastructure.repository;

import java.util.Collection;
import java.util.List;

import com.maodot.luckdraw.infrastructure.repository.dto.PrizeDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;


public interface PrizeRepo {

	@Insert("INSERT INTO t_luck_draw_prize(`prize_code`,`name`,`url`,`type`,`value`,`prize_status`,`position`,`phase`,`create_at`) "
	+"VALUES(#{prizeCode},#{name},#{url},#{type},#{value},#{prizeStatus},#{position},#{phase},NOW())")
	@Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
	Integer create(PrizeDto prize);

	@Update("<script>UPDATE t_luck_draw_prize SET "
	+"<if test='prizeCode != null'>`prize_code`=#{prizeCode},</if>"
	+"<if test='name != null'>`name`=#{name},</if>"
	+"<if test='url != null'>`url`=#{url},</if>"
	+"<if test='type != null'>`type`=#{type},</if>"
	+"<if test='value != null'>`value`=#{value},</if>"
	+"<if test='prizeStatus != null'>`prize_status`=#{prizeStatus},</if>"
	+"<if test='position != null'>`position`=#{position},</if>"
	+"<if test='phase != null'>`phase`=#{phase},</if>"
	+"update_at=NOW() WHERE id=#{id}</script>")
	Integer update(PrizeDto prize);

	@Update("UPDATE t_luck_draw_prize SET status=0 WHERE id=#{id}")
	Integer delete(@Param("id") Long id);

	@Select("<script>SELECT COUNT(*) FROM t_luck_draw_prize WHERE status=1 <if test='name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%')</if><if test='type != \"\"'> AND type LIKE CONCAT('%', #{type}, '%')</if><if test='prizeStatus != \"\"'> AND prize_status LIKE CONCAT('%', #{prizeStatus}, '%')</if></script>")
	Integer countByCondition(@Param("name") String name, @Param("type") Integer type, @Param("prizeStatus") Integer prizeStatus);

	@Select("<script>SELECT * FROM t_luck_draw_prize WHERE status=1 <if test='name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%')</if><if test='type != \"\"'> AND type LIKE CONCAT('%', #{type}, '%')</if><if test='prizeStatus != \"\"'> AND prize_status LIKE CONCAT('%', #{prizeStatus}, '%')</if> ORDER BY id DESC LIMIT ${skip}, ${size}</script>")
	List<PrizeDto> listByCondition(@Param("name") String name, @Param("type") Integer type, @Param("prizeStatus") Integer prizeStatus, @Param("skip") int skip, @Param("size") int size);

	@Select("SELECT * FROM t_luck_draw_prize WHERE status=1 AND prize_code = #{prizeCode}")
	PrizeDto getOne(@Param("prizeCode") String prizeCode);

	@Select("<script>SELECT * FROM t_luck_draw_prize WHERE status=1 AND prize_code IN <foreach collection='prizeCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
	List<PrizeDto> getList(@Param("prizeCodes") Collection<String> prizeCodes);

	@Select("SELECT * FROM t_luck_draw_prize WHERE id=#{id}")
	PrizeDto get(@Param("id") Long id);

/********************************** 以下是自定义请求 **********************************/

}