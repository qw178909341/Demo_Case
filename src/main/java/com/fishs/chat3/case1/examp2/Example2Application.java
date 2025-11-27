package com.fishs.chat3.case1.examp2;

/**
 * @Description:
 * @Author: lf
 * @Date: 2025/11/13 13:57
 */
public class Example2Application {
    static void main() {
        // 给一个有普通收入、工资收入和享受津贴的小伙伴算税:
        Income[] incomes = new Income[] {
                new Income(3000.0),
                new Salary(7500.0),
                new StateCouncilSpecialAllowance(15000.0)
        };
        System.out.println(totalTax(incomes));
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income: incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

class Income {
    protected double income;
    public Income(double income) {
        this.income = income;
    }


    public double getTax() {
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0.0;
        }
        return (income - 5000) * 0.2;
    }
}
class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }
    @Override
    public double getTax() {
        return 0;
    }
}
