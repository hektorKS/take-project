/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 */

package com.hektorks.config.database.typehandlers;


import com.hektorks.take.common.model.MovieCategory;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(MovieCategory.class)
public class MovieCategoryTypeHandler extends BaseTypeHandler<MovieCategory> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, MovieCategory parameter, JdbcType jdbcType)
      throws SQLException {
    ps.setString(i, parameter.getName());
  }

  @Override
  public MovieCategory getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return MovieCategory.fromString(rs.getString(columnName));
  }

  @Override
  public MovieCategory getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return MovieCategory.fromString(rs.getString(columnIndex));
  }

  @Override
  public MovieCategory getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return MovieCategory.fromString(cs.getString(columnIndex));
  }
}
