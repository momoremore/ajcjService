/**
 * Copyright(c) SUPCON 2008-2011. �㽭����п���Ϣ�������޹�˾
 */
package its.webservice.common;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

/**
 * ϵͳ���ƣ����ܽ�ͨWebService����(ITSWebService)
 * ����ģ�飺��ҳ����ģ��
 * �������������ݲ�ѯ�������ҳ����
 * �ļ�����its.webservice.common.SplitPageResultSetExtractor.java
 * �汾��Ϣ��1.00
 * 
 * �������ţ��з�����
 * �����ߣ� lzk
 * ����ʱ�䣺Jan 25, 2011 4:22:30 PM
 * �޸��ߣ� lzk
 * �޸�ʱ�䣺Jan 25, 2011 4:22:30 PM
 */
public class SplitPageResultSetExtractor implements ResultSetExtractor {

	/** ��ʼ�к� */
	private final int startPosition;

    /** �����к� */
	private final int endPosition;

    /** �а�װ�� */
	private final RowMapper rowMapper;

    /**
     * ���캯��
     *
     * @param rowMapper RowMapper
     * @param startPosition int
     * @param endPosition int
     */
	public SplitPageResultSetExtractor(RowMapper rowMapper, int startPosition, int endPosition) {
		Assert.notNull(rowMapper, "RowMapper is required");
		this.rowMapper = rowMapper;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}

    /**
     * ���캯��
     *
     * @param startPosition int
     * @param endPosition int
     */
	public SplitPageResultSetExtractor(int startPosition, int endPosition) {
		this.rowMapper = null;
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}

	/**
	 * ����������,���ӿ��Զ����ã�������߲�Ӧ�õ���
	 * 
	 * @param rs ResultSet
	 * @throws SQLException
	 * @throws DataAccessException
	 * @return Object
	 */
	public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Object> resultList = new ArrayList<Object>();
		Map<String, Object> rowMap = null;
		ResultSetMetaData rsmd = null;

//		int rowNum = 0;
//		point: while (rs.next()) {
//			++rowNum;
//			if (rowNum < startPosition) {
//				continue point;
//			} else if (rowNum >= endPosition) {
//				break point;
//			} else {
//				result.add(this.rowMapper.mapRow(rs, rowNum));
//			}
//		}

        int position = 0;
        while (rs.next()) {
            position++;
            if (position >= startPosition && position <= endPosition) {
            	if (this.rowMapper == null) {
            		rowMap = new HashMap<String, Object>();

            		// ����ǰ��¼��װ��rowMap
            		rsmd = rs.getMetaData();
            		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        if (rsmd.getColumnType(i) == Types.VARCHAR) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getString(i));
                        } else if (rsmd.getColumnType(i) == Types.INTEGER) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getInt(i));
                        } else if (rsmd.getColumnType(i) == Types.DOUBLE) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getDouble(i));
                        } else if (rsmd.getColumnType(i) == Types.DATE) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getDate(i));                                                             	
                        } else if (rsmd.getColumnType(i) == Types.TIMESTAMP) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getTimestamp(i));
                        } else if (rsmd.getColumnType(i) == Types.FLOAT) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getFloat(i));
                        } else if (rsmd.getColumnType(i) == Types.DECIMAL) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getBigDecimal(i));
                        } else if (rsmd.getColumnType(i) == Types.NUMERIC) {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getBigDecimal(i));
                        } else {
                			rowMap.put(rsmd.getColumnName(i).toLowerCase(), rs.getObject(i));
                        }
            		}

            		resultList.add(rowMap);
            	} else {
            		resultList.add(this.rowMapper.mapRow(rs, position));
            	}
                if (position == endPosition) {
                    break;
                }
            }
        }

		return resultList;
	}

}
