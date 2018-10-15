package com.maodot.luckdraw.infrastructure.repository;

import java.util.Collection;
import java.util.List;

import com.maodot.luckdraw.infrastructure.repository.dto.RecordDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;


public interface RecordRepo {

	@Insert("INSERT INTO t_luck_draw_record(`record_code`,`member_code`,`member_phone`,`prize_code`,`result`,`create_at`) "
	+"VALUES(#{recordCode},#{memberCode},#{memberPhone},#{prizeCode},#{result},NOW())")
	@Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
	Integer create(RecordDto record);

	@Update("<script>UPDATE t_luck_draw_record SET "
	+"<if test='recordCode != null'>`record_code`=#{recordCode},</if>"
	+"<if test='memberCode != null'>`member_code`=#{memberCode},</if>"
	+"<if test='memberPhone != null'>`member_phone`=#{memberPhone},</if>"
	+"<if test='prizeCode != null'>`prize_code`=#{prizeCode},</if>"
	+"<if test='result != null'>`result`=#{result},</if>"
	+"update_at=NOW() WHERE id=#{id}</script>")
	Integer update(RecordDto record);

	@Update("UPDATE t_luck_draw_record SET status=0 WHERE id=#{id}")
	Integer delete(@Param("id") Long id);

	@Select("<script>SELECT COUNT(*) FROM t_luck_draw_record WHERE status=1 <if test='memberCode != \"\"'> AND member_code LIKE CONCAT('%', #{memberCode}, '%')</if><if test='prizeCode != \"\"'> AND prize_code LIKE CONCAT('%', #{prizeCode}, '%')</if></script>")
	Integer countByCondition(@Param("memberCode") String memberCode, @Param("prizeCode") String prizeCode);

	@Select("<script>SELECT * FROM t_luck_draw_record WHERE status=1 <if test='memberCode != \"\"'> AND member_code LIKE CONCAT('%', #{memberCode}, '%')</if><if test='prizeCode != \"\"'> AND prize_code LIKE CONCAT('%', #{prizeCode}, '%')</if> ORDER BY id DESC LIMIT ${skip}, ${size}</script>")
	List<RecordDto> listByCondition(@Param("memberCode") String memberCode, @Param("prizeCode") String prizeCode, @Param("skip") int skip, @Param("size") int size);

	@Select("SELECT * FROM t_luck_draw_record WHERE status=1 AND record_code = #{recordCode}")
	RecordDto getOne(@Param("recordCode") String recordCode);

	@Select("<script>SELECT * FROM t_luck_draw_record WHERE status=1 AND record_code IN <foreach collection='recordCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
	List<RecordDto> getList(@Param("recordCodes") Collection<String> recordCodes);

	@Select("SELECT * FROM t_luck_draw_record WHERE id=#{id}")
	RecordDto get(@Param("id") Long id);

/********************************** 以下是自定义请求 **********************************/

}