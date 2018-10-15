package com.maodot.luckdraw.infrastructure.repository;

import java.util.Collection;
import java.util.List;

import com.maodot.luckdraw.infrastructure.repository.dto.ProbabilityDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;


public interface ProbabilityRepo {

	@Insert("INSERT INTO t_luck_draw_probability(`probability_code`,`prize_code`,`prize_phase`,`probability`,`frozen`,`prize_day_max_times`,`user_prize_month_max_times`,`create_at`) "
	+"VALUES(#{probabilityCode},#{prizeCode},#{prizePhase},#{probability},#{frozen},#{prizeDayMaxTimes},#{userPrizeMonthMaxTimes},NOW())")
	@Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
	Integer create(ProbabilityDto probability);

	@Update("<script>UPDATE t_luck_draw_probability SET "
	+"<if test='probabilityCode != null'>`probability_code`=#{probabilityCode},</if>"
	+"<if test='prizeCode != null'>`prize_code`=#{prizeCode},</if>"
	+"<if test='prizePhase != null'>`prize_phase`=#{prizePhase},</if>"
	+"<if test='probability != null'>`probability`=#{probability},</if>"
	+"<if test='frozen != null'>`frozen`=#{frozen},</if>"
	+"<if test='prizeDayMaxTimes != null'>`prize_day_max_times`=#{prizeDayMaxTimes},</if>"
	+"<if test='userPrizeMonthMaxTimes != null'>`user_prize_month_max_times`=#{userPrizeMonthMaxTimes},</if>"
	+"update_at=NOW() WHERE id=#{id}</script>")
	Integer update(ProbabilityDto probability);

	@Update("UPDATE t_luck_draw_probability SET status=0 WHERE id=#{id}")
	Integer delete(@Param("id") Long id);

	@Select("<script>SELECT COUNT(*) FROM t_luck_draw_probability WHERE status=1 <if test='prizeCode != \"\"'> AND prize_code LIKE CONCAT('%', #{prizeCode}, '%')</if></script>")
	Integer countByCondition(@Param("prizeCode") String prizeCode);

	@Select("<script>SELECT * FROM t_luck_draw_probability WHERE status=1 <if test='prizeCode != \"\"'> AND prize_code LIKE CONCAT('%', #{prizeCode}, '%')</if> ORDER BY id DESC LIMIT ${skip}, ${size}</script>")
	List<ProbabilityDto> listByCondition(@Param("prizeCode") String prizeCode, @Param("skip") int skip, @Param("size") int size);

	@Select("SELECT * FROM t_luck_draw_probability WHERE status=1 AND probability_code = #{probabilityCode}")
	ProbabilityDto getOne(@Param("probabilityCode") String probabilityCode);

	@Select("<script>SELECT * FROM t_luck_draw_probability WHERE status=1 AND probability_code IN <foreach collection='probabilityCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
	List<ProbabilityDto> getList(@Param("probabilityCodes") Collection<String> probabilityCodes);

	@Select("SELECT * FROM t_luck_draw_probability WHERE id=#{id}")
	ProbabilityDto get(@Param("id") Long id);

/********************************** 以下是自定义请求 **********************************/

}