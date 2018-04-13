package entity;
import java.math.BigDecimal;
import java.util.HashMap;

public class Calculator {

	private String fristNumber;
	private String secondNumber;
	private char operator;
	private HashMap<String, String >errors = new HashMap<>();
	public String getFristNumber() {
		return fristNumber;
	}
	public void setFristNumber(String fristNumber) {
		this.fristNumber = fristNumber;
	}
	public String getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(String secondNumber) {
		this.secondNumber = secondNumber;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public HashMap<String, String> getErrors() {
		return errors;
	}
	public void setErrors(HashMap<String, String> errors) {
		this.errors = errors;
	}
	public String calculator()
	{
		BigDecimal result = null;
		BigDecimal frist = new BigDecimal(fristNumber);
		BigDecimal second = new BigDecimal(secondNumber);
		switch (operator) {
		case '+':
			result = frist.add(second);
			break;
		case '-':
			result = frist.subtract(second);
			break;
		case '*':
			result = frist.multiply(second);
			break;
		case '/':
			if("0".equals(second))
			{
				throw new RuntimeException("��������Ϊ0");
			}
			result = frist.divide(second);
			break;
		default:
			break;
		}
		return result.toString();
	}
	public boolean validate()
	{
		boolean flag = true;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\d+");
		if(fristNumber==null ||"".equals(fristNumber) )
		{
			errors.put("fristNumber", "��һ�����ֲ���Ϊ��");
			flag = false;
		}
		else if(!p.matcher(fristNumber).matches() )
		{
			errors.put("fristNumber", "��һ�����������Ϊ����");
			flag = false;
		}
		if(secondNumber==null ||"".equals(secondNumber) )
		{
			errors.put("secondNumber", "�ڶ������ֲ���Ϊ��");
			flag = false;
		}
		else if(!p.matcher(secondNumber).matches() )
		{
			errors.put("secondNumber", "�ڶ������������Ϊ����");
			flag = false;
		}
		return flag;
	}
}
