package ejbs;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
public class Calculation {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
float number1;
float number2;
String operation;
float result;
public Calculation() 
{}

public float getNumber1() {
	return number1;
}
public void setNumber1(float number1) {
	this.number1 = number1;
}
public float getNumber2() {
	return number2;
}
public void setNumber2(float number2) {
	this.number2 = number2;
}
public String getOperation() {
	return operation;
}
public void setOperation(String operation) {
	this.operation = operation;
}
public float getResult() {
	return result;
}
public void setResult(float result) {
	this.result = result;
}
}
