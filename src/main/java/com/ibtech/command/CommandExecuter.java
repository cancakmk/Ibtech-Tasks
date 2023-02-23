package com.ibtech.command;

import java.lang.reflect.Method;
import java.util.List;

import com.ibtech.dbo.CommandDbo;
import com.ibtech.model.Command;
import com.ibtech.model.Customer;


public class CommandExecuter {

	
	public static Method executer(String commandName)  {
		try {
			CommandDbo commandDao = new CommandDbo();
			Command command = commandDao.getCommand(commandName);

			Class<?> c = Class.forName("com.ibtech.command.operation." + command.getClassName());
		
			Object obj = c.newInstance();
			Method method=c.getDeclaredMethod(command.getMethodName(),List.class,Customer.class);
			//method.invoke(obj);
			System.out.println("-> Executing works fine");
			return method;

		} catch (Exception e) {
			System.out.println("-> Executing failed");
			e.printStackTrace();
	
		}
		return null;		
	}

	}


