package ejbs;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
public class Calculation {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
int id;
float num1;
float num2;
String op;
float result;
public Calculation() 
{}

public float getNum1() {
	return num1;
}
public void setNum1(float num1) {
	this.num1 = num1;
}
public float getNum2() {
	return num2;
}
public void setNum2(float num2) {
	this.num2 = num2;
}
public String getOp() {
	return op;
}
public void setOp(String op) {
	this.op = op;
}
public float getResult() {
	return result;
}
public void setResult(float result) {
	this.result = result;
}
}