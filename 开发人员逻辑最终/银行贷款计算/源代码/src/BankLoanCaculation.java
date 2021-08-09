import java.util.InputMismatchException;
import java.util.Scanner;
public class BankLoanCaculation {
    public static void main(String[]args){
        double loanAmount;            //贷款金额
        double annualInterestRate = 0.0563;    //年利率
        double monthlyInterestRate;            //月利率
        double loanTerm;              //贷款年限
        double repaymentMonths;       //还款月数
        double loanInterest;          //贷款利息
        double grossInterest;         //总利息
        double monthlyPrincipalRepayments;        //每月还款的本金
        double interestOnMonthlyRepayments;       //每月还款的利息
        double monthlyRepaymentAmount;            //每月还款本息
        double theAccumulatedPrincipalHasBeenReturned=0;
        double sum=0;
        double monthlyPrincipalRepayment;                   //每月还款本金
        double monthlyInterestRepayment;                    //每月还款利息
        monthlyInterestRate=annualInterestRate/12;
        System.out.print("月利率为："+monthlyInterestRate+"\n");
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入贷款金额：");
            loanAmount = sc.nextDouble();
            System.out.print("请输入贷款年限：");
            loanTerm = sc.nextDouble();
            System.out.print("请输入还款方式：");
             String input = sc.next();
            repaymentMonths=loanTerm*12;
            if(input.equals("等额本息")){
                monthlyRepaymentAmount = ((loanAmount*monthlyInterestRate*(Math.pow(1+monthlyInterestRate,repaymentMonths)))/(Math.pow(1+monthlyInterestRate,repaymentMonths)-1));
                System.out.print("每月还款金额为："+monthlyRepaymentAmount+"\n");
                sum=monthlyRepaymentAmount*loanTerm*12;
                System.out.print("总共还款："+sum+"元"+"\n");
                System.out.print("总利息是"+(sum-loanAmount)+"元"+"\n");
            }else if (input.equals("等额本金")){
                for(int i = 1;i<=repaymentMonths;i++) {
                    monthlyPrincipalRepayments=loanAmount/repaymentMonths;
                    monthlyRepaymentAmount = (loanAmount / repaymentMonths) + (loanAmount - theAccumulatedPrincipalHasBeenReturned) * monthlyInterestRate;
                    System.out.print("第"+i+"个月"+"还款金额为：" + monthlyRepaymentAmount + "\n");
                    System.out.print("第"+i+"个月"+"还款利息为："+(monthlyRepaymentAmount-monthlyPrincipalRepayments)+"\n");
                    theAccumulatedPrincipalHasBeenReturned = monthlyPrincipalRepayments*i;     //已归还本金累计额
                    System.out.print("已归还本金累计额："+theAccumulatedPrincipalHasBeenReturned+"\n");
                    System.out.print("--------------------------------------------------------------------------"+"\n");


                    sum+=monthlyRepaymentAmount;
                }
                System.out.print("总共还款："+sum+"元"+"\n");
                System.out.print("总利息是："+(sum-loanAmount)+"元"+"\n");
            }
        }catch (InputMismatchException e1){
            System.out.print("请输入数字！");
        }catch (ArithmeticException e2){
            System.out.print("算法有误！");
        }catch (Exception e3){
            System.out.print("其他异常！");
        }finally {
            System.out.print("谢谢使用！");
        }
    }
}
