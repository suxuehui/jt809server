package com.ltmonitor.jt809.protocol.receive;

import org.apache.log4j.Logger;

import com.ltmonitor.jt809.app.T809Manager;
import com.ltmonitor.jt809.model.JT809Message;
import com.ltmonitor.jt809.protocol.IReceiveProtocol;

/**
 * 启动车辆定位信息交换请求消息
 * @author tianfei
 *
 */
public class DownExgMsgReturnStartUp implements IReceiveProtocol {
	private Logger logger = Logger.getLogger(DownExgMsgReturnStartUp.class);

	public String handle(JT809Message message) {
		String dataBody = message.getMessageBody();
		MessageParser mp = new MessageParser(dataBody);

		String plateNo = mp.getString(21);

		int plateColor = mp.getInt(1);

		int dataType = mp.getInt(2);

		int dataLength = mp.getInt(4);

		int reasonCode = mp.getInt(1);
		//1205应答
		T809Manager.UpExgMsgReturnStartUpAck(plateNo, plateColor);

		this.logger.info("申请交换指定车辆定位信息应答包入库成功" + dataBody);

		return "";
	}

	private void updateUploadOrder() {
		System.out.println("暂无更新");
	}
}
