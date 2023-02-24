package com.ibtech.command;

import java.lang.reflect.Method;
import com.ibtech.bag.Bag;
import com.ibtech.dbo.CommandDbo;
import com.ibtech.model.Command;



public class CommandExecuter {

	
	
	public static  Bag executer(String commandName,Bag bag)  {
		try {
			CommandDbo commandDao = new CommandDbo();
			Command command = commandDao.getCommand(commandName);
			
			if (!isValue(command)) {
				throw new Exception("CommandString not found!");
			}

			Class<?> c = Class.forName("com.ibtech.command.operation." + command.getClassName());
		
			
			Object obj = c.getDeclaredConstructor().newInstance();
			Method method;
			Bag dbBag;
			
			
			if (!bag.getMap().isEmpty()) {
			
				method = c.getDeclaredMethod(command.getMethodName(), Bag.class);
				dbBag = (Bag) method.invoke(obj, bag);

			} else {
				method = c.getDeclaredMethod(command.getMethodName());
				dbBag = (Bag) method.invoke(obj);
			}
			System.out.println("-> Execute works right");
			return dbBag;

		} catch (Exception e) {
			System.out.println("-> Executing failed");
			e.printStackTrace();
	
		}
		return null;		
	}
	
	
	private static boolean isValue(Command command) {
		if (command == null) {
			System.out.println("Command Couldn't Found");
			return false;
		}
		System.out.println("-> Command Information; \n\t" + 
		command.getCommandName() + "\n\t" + command.getClassName() + "\n\t" + command.getMethodName());
		return true;
	}
	
	

	}


