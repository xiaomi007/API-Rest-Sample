package fr.xiaomi.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class ToJson {

	public JSONArray toJSONArray(ResultSet rs) throws Exception {

		int count = 1;

		JSONArray json = new JSONArray();

		try {
			ResultSetMetaData rsmd = rs.getMetaData();

			int numColumns = rsmd.getColumnCount();

			while (rs.next()) {
				JSONObject obj = new JSONObject();
				System.out.println("row #" + count++);
				int countin = 1;
				
				for (int i = 1; i <= numColumns; i++) {

					System.out.println("column #" + countin++);
					String columnName = rsmd.getColumnName(i);

					switch (rsmd.getColumnType(i)) {
					case Types.ARRAY:
						obj.put(columnName, rs.getArray(columnName));
						System.out.println("toJson:Array");
						break;

					case Types.BIGINT:
						obj.put(columnName, rs.getLong(columnName));
						System.out.println("toJson:BigInt");
						break;

					case Types.BINARY:
						obj.put(columnName, rs.getBytes(columnName));
						System.out.println("toJson:BigInt");
						break;

					case Types.BIT:
						obj.put(columnName, rs.getBoolean(columnName));
						System.out.println("toJson:BIT");
						break;

					case Types.BLOB:
						obj.put(columnName, rs.getBlob(columnName));
						System.out.println("toJson:Blob");
						break;

					case Types.BOOLEAN:
						obj.put(columnName, rs.getBoolean(columnName));
						System.out.println("toJson:Boolean");
						break;

					case Types.CHAR:
						obj.put(columnName, rs.getString(columnName));
						System.out.println("toJson:Char");
						break;

					case Types.CLOB:
						obj.put(columnName, rs.getClob(columnName));
						System.out.println("toJson:Clob");
						break;

					case Types.DATALINK:

						System.out.println("toJson:DataLink to do");
						break;

					case Types.DATE:
						obj.put(columnName, rs.getDate(columnName));
						System.out.println("Date");
						break;

					case Types.DECIMAL:
						System.out.println("toJson:Decimal to do");
						break;

					case Types.DISTINCT:
						System.out.println("toJson:Distinct to do");
						break;

					case Types.DOUBLE:
						obj.put(columnName, rs.getDouble(columnName));
						System.out.println("toJson:Double");
						break;

					case Types.FLOAT:
						obj.put(columnName, rs.getFloat(columnName));
						System.out.println("toJson:Float");
						break;

					case Types.INTEGER:
						obj.put(columnName, rs.getInt(columnName));
						System.out.println("toJson:Integer");
						break;

					case Types.JAVA_OBJECT:
						obj.put(columnName, rs.getObject(columnName));
						System.out.println("toJson:JavaObject");
						break;

					case Types.LONGNVARCHAR:
						obj.put(columnName, rs.getNCharacterStream(columnName));
						System.out.println("toJson:LongVarChar");
						break;

					case Types.LONGVARBINARY:
						// obj.put(columnName, rs.getBinaryStream(columnName));
						System.out.println("toJson:LongVarBinary to do");
						break;

					case Types.LONGVARCHAR:
						obj.put(columnName, rs.getString(columnName));
						System.out.println("toJson:LongVarChar");
						break;

					case Types.NCHAR:
						System.out.println("toJson:NChar to do");

						break;

					case Types.NCLOB:
						obj.put(columnName, rs.getNClob(columnName));
						System.out.println("toJson:NClob");
						break;

					case Types.NULL:
						System.out.println("toJson:Null to do");
						break;

					case Types.NUMERIC:
						obj.put(columnName, rs.getBigDecimal(columnName));
						System.out.println("toJson:Char");
						break;

					case Types.NVARCHAR:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:NVarChar to do");
						break;

					case Types.OTHER:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:Other to do");
						break;

					case Types.REAL:
						obj.put(columnName, rs.getFloat(columnName));
						System.out.println("toJson:Real");
						break;

					case Types.REF:
						obj.put(columnName, rs.getRef(columnName));
						System.out.println("toJson:Ref");
						break;

					case Types.REF_CURSOR:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:RefCursor to do");
						break;

					case Types.ROWID:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:RowID to do");
						break;

					case Types.SMALLINT:
						obj.put(columnName, rs.getShort(columnName));
						System.out.println("toJson:SmallInt");
						break;

					case Types.SQLXML:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:SqlXml to do");
						break;

					case Types.STRUCT:
						// obj.put(columnName, rs.getS(numColumns));
						System.out.println("toJson:Struct to do");
						break;

					case Types.TIME:
						obj.put(columnName, rs.getTime(columnName));
						System.out.println("toJson:Time");
						break;

					case Types.TIME_WITH_TIMEZONE:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out.println("toJson:TimeWithTimezone to do");
						break;

					case Types.TIMESTAMP:
						obj.put(columnName, rs.getTimestamp(columnName));
						System.out.println("toJson:TimeStamp");
						break;

					case Types.TIMESTAMP_WITH_TIMEZONE:
						// obj.put(columnName,
						// rs.getCharacterStream(numColumns));
						System.out
								.println("toJson:TimeStampWithTimezone to do");
						break;

					case Types.TINYINT:
						obj.put(columnName, rs.getByte(columnName));
						System.out.println("toJson:TinyInt");
						break;

					case Types.VARBINARY:
						obj.put(columnName, rs.getBytes(columnName));
						System.out.println("toJson:VarBinary");
						break;

					case Types.VARCHAR:
						obj.put(columnName, rs.getString(columnName));
						System.out.println("toJson:VarChar");
						break;

					default:
						System.out.println("default json");
						break;
					}
					System.out.println("obj:" + obj.toString());

				}
				json.put(obj);
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return json;

	}
}
