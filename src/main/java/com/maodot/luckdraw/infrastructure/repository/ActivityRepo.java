package com.maodot.luckdraw.infrastructure.repository;

import java.util.Collection;
import java.util.List;

import com.maodot.luckdraw.infrastructure.repository.dto.ActivityDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;


public interface ActivityRepo {

	@Insert("INSERT INTO t_luck_draw_activity(`activity_code`,`name`,`content`,`begin_time`,`end_time`,`activity_status`,`create_at`) "
	+"VALUES(#{activityCode},#{name},#{content},#{beginTime},#{endTime},#{activityStatus},NOW())")
	@Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
	Integer create(ActivityDto activity);

	@Update("<script>UPDATE t_luck_draw_activity SET "
	+"<if test='activityCode != null'>`activity_code`=#{activityCode},</if>"
	+"<if test='name != null'>`name`=#{name},</if>"
	+"<if test='content != null'>`content`=#{content},</if>"
	+"<if test='beginTime != null'>`begin_time`=#{beginTime},</if>"
	+"<if test='endTime != null'>`end_time`=#{endTime},</if>"
	+"<if test='activityStatus != null'>`activity_status`=#{activityStatus},</if>"
	+"update_at=NOW() WHERE id=#{id}</script>")
	Integer update(ActivityDto activity);

	@Update("UPDATE t_luck_draw_activity SET status=0 WHERE id=#{id}")
	Integer delete(@Param("id") Long id);

	@Select("<script>SELECT COUNT(*) FROM t_luck_draw_activity WHERE status=1 <if test='name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%')</if><if test='activityStatus != \"\"'> AND activity_status LIKE CONCAT('%', #{activityStatus}, '%')</if></script>")
	Integer countByCondition(@Param("name") String name, @Param("activityStatus") Integer activityStatus);

	@Select("<script>SELECT * FROM t_luck_draw_activity WHERE status=1 <if test='name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%')</if><if test='activityStatus != \"\"'> AND activity_status LIKE CONCAT('%', #{activityStatus}, '%')</if> ORDER BY id DESC LIMIT ${skip}, ${size}</script>")
	List<ActivityDto> listByCondition(@Param("name") String name, @Param("activityStatus") Integer activityStatus, @Param("skip") int skip, @Param("size") int size);

	@Select("SELECT * FROM t_luck_draw_activity WHERE status=1 AND activity_code = #{activityCode}")
	ActivityDto getOne(@Param("activityCode") String activityCode);

	@Select("<script>SELECT * FROM t_luck_draw_activity WHERE status=1 AND activity_code IN <foreach collection='activityCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach></script>")
	List<ActivityDto> getList(@Param("activityCodes") Collection<String> activityCodes);

	@Select("SELECT * FROM t_luck_draw_activity WHERE id=#{id}")
	ActivityDto get(@Param("id") Long id);

/********************************** 以下是自定义请求 **********************************/

}