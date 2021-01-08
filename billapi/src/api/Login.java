package api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modal.User;
import modal.User_bill;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;

public class Login {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		HttpUtil.createServer(40000)
		.addAction("/api/balance", (req, res)->{
			String user_id = "";
			Float balance = 0f;
			int error_code = 0;
			String error_msg = "";
			String user_passwd = "";
			try {
				user_id = req.getParams().get("user_id", 0);
				user_passwd = req.getParams().get("user_passwd",0);
				if(user_id ==null || user_passwd == null) {
					error_code = 4;
					error_msg = "参数格式错误";
					balance = 0f;
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("error_code", error_code);
					jsonObject.put("error_msg", error_msg);
					jsonObject.put("balance", balance);
					res.write(jsonObject.toJSONString(0));
					return;
				}
				try {
					List<Entity> list = Db.use().findAll(Entity.create("user_info").set("user_id", user_id));
					if(list!=null&&list.size()!=0) {
						list = Db.use().findAll(Entity.create("user_info").set("user_id", user_id).set("user_passwd", user_passwd));
						if(list!=null&&list.size()!=0) {
							list = Db.use().findAll(Entity.create("user_balance").set("user_id", list.get(0).get("user_id")));
							try {
								balance = (Float)list.get(0).get("balance_amount");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							error_code = 0;
							error_msg = "正常";
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("error_code", error_code);
							jsonObject.put("error_msg", error_msg);
							jsonObject.put("balance", balance);
							res.write(jsonObject.toJSONString(0));
							return;
						}else {
							error_code = 2;
							error_msg = "登录密码错误";
							balance = 0f;
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("error_code", error_code);
							jsonObject.put("error_msg", error_msg);
							jsonObject.put("balance", balance);
							res.write(jsonObject.toJSONString(0));
							return;
						}
					}else {
						error_code = 1;
						error_msg = "⽤户不存在";
						balance = 0f;
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("error_code", error_code);
						jsonObject.put("error_msg", error_msg);
						jsonObject.put("balance", balance);
						res.write(jsonObject.toJSONString(0));
						return;
					}
				} catch (SQLException e) {
					error_code = 3;
					error_msg = "系统内部错误";
					balance = 0f;
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("error_code", error_code);
					jsonObject.put("error_msg", error_msg);
					jsonObject.put("balance", balance);
					res.write(jsonObject.toJSONString(0));
					return;
				}
			} catch (JSONException e) {
				error_code = 3;
				error_msg = "系统内部错误";
				balance = 0f;
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("error_code", error_code);
				jsonObject.put("error_msg", error_msg);
				jsonObject.put("balance", balance);
				res.write(jsonObject.toJSONString(0));
				return;
			}

		})
		.addAction("/api/bill", (req, res)->{
			String user_id = "";
			List<User_bill> bills = new ArrayList<User_bill>();
			int error_code = 0;
			String error_msg = "";
			String user_transwd = "";
			String bill_year = "";
			String bill_month = "";
			String bill_type = "";
			String bill_week = "";
			try {
				user_id = req.getParams().get("user_id", 0);
				user_transwd = req.getParams().get("user_transwd",0);
				bill_year = req.getParams().get("bill_year", 0);
				bill_month = req.getParams().get("bill_month",0);
				bill_type = req.getParams().get("bill_type", 0);
				bill_week = req.getParams().get("bill_week", 0);
				if(user_id ==null || user_transwd == null) {
					error_code = 4;
					error_msg = "参数格式错误";
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("error_code", error_code);
					jsonObject.put("error_msg", error_msg);
					jsonObject.put("bills", bills);
					res.write(jsonObject.toJSONString(0));
					return;
				}
				try {
					List<Entity> list = Db.use().findAll(Entity.create("user_info").set("user_id", user_id));
					if(list!=null&&list.size()!=0) {
						list = Db.use().findAll(Entity.create("user_info").set("user_id", user_id).set("user_transwd", user_transwd));
						if(list!=null&&list.size()!=0) {
							String sql = "select * from user_bill where user_id = '"+user_id+"'";
							if(bill_year != null) {
								sql += " and bill_year = "+bill_year;
							}
							if(bill_type != null) {
								sql += " and bill_type = "+bill_type;
							}
							if(bill_month != null) {
								sql += " and bill_month = "+bill_month;
							}
							if(bill_week != null) {
								sql += " and bill_week = "+bill_week;
							}

							list = Db.use().query(sql);
							for(Entity entity:list) {
								User_bill user_bill = new User_bill();
								user_bill.setBill_amount(entity.getFloat("bill_amount"));
								if(entity.getInt("bill_type") == 0) {
									user_bill.setBill_type("in");
								}
								if(entity.getInt("bill_type") == 1) {
									user_bill.setBill_type("out");
								}
								user_bill.setDate(entity.getDate("bill_time").toLocaleString());
								bills.add(user_bill);

							}
							error_code = 0;
							error_msg = "正常";
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("error_code", error_code);
							jsonObject.put("error_msg", error_msg);
							jsonObject.put("bills", bills);
							res.write(jsonObject.toJSONString(0));
							return;
						}else {
							error_code = 2;
							error_msg = "登录密码错误";
							JSONObject jsonObject = new JSONObject();
							jsonObject.put("error_code", error_code);
							jsonObject.put("error_msg", error_msg);
							jsonObject.put("bills", bills);
							res.write(jsonObject.toJSONString(0));
							return;
						}
					}else {
						error_code = 1;
						error_msg = "⽤户不存在";
						JSONObject jsonObject = new JSONObject();
						jsonObject.put("error_code", error_code);
						jsonObject.put("error_msg", error_msg);
						jsonObject.put("bills", bills);
						res.write(jsonObject.toJSONString(0));
						return;
					}
				} catch (SQLException e) {
					error_code = 3;
					error_msg = "系统内部错误";
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("error_code", error_code);
					jsonObject.put("error_msg", error_msg);
					jsonObject.put("bills", bills);
					res.write(jsonObject.toJSONString(0));
					return;
				}
			} catch (JSONException e) {
				error_code = 3;
				error_msg = "系统内部错误";
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("error_code", error_code);
				jsonObject.put("error_msg", error_msg);
				jsonObject.put("bills", bills);
				res.write(jsonObject.toJSONString(0));
				return;
			}

		})
		.start();
	}
}
