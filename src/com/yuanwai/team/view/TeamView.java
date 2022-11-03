package com.yuanwai.team.view;

import com.yuanwai.team.domain.Employee;
import com.yuanwai.team.domain.Programmer;
import com.yuanwai.team.service.NameListService;
import com.yuanwai.team.service.TSUtility;
import com.yuanwai.team.service.TeamException;
import com.yuanwai.team.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag) {
            if (menu != '1') {
                listAllEmployees();
            }
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：");
            menu = TSUtility.readMenuSelection();
            switch (menu) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;

            }
        }
    }

    /**
     * 显示所有的员工信息
     */
    private void listAllEmployees() {
        System.out.println("-------------------------------------开发团队调度软件-------------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if (employees.length == 0 || employees == null) {
            System.out.println("公司中没有任何员工信息");
        }else {
            System.out.println("ID\t\t姓名\t\t\t年龄\t\t工资\t\t\t职位\t\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private void getTeam() {
//        System.out.println("查看团队列表");
        System.out.println("------------------------------------团队成员列表--------------------------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队目前没有成员！");
        } else {
            System.out.println("TID/ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t奖金\t\t股票\n");
            for (int i = 0; i < team.length; i++) {
                Programmer programmer = team[i];
                System.out.println(programmer.getDetailsForTeam());
            }
            System.out.println("---------------------------------------------------------------------------------------");

        }
    }

    private void addMember() {
//        System.out.println("addMember");
        System.out.println("------------------------------------添加成员--------------------------------------\n");
        System.out.println("请输入延迟添加的员工ID：");
        int id = TSUtility.readInt();

        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");


        } catch (TeamException e) {
            System.out.println("添加失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();

    }

    private void deleteMember() {

        System.out.println("------------------------------------删除团队成员--------------------------------------\n");
        System.out.println("请输入要删除删除员工的TID：");
        int memberId = TSUtility.readInt();
        System.out.println("确认是否删除（Y/N）");
        char isDelete = TSUtility.readConfirmSelection();
        if (isDelete == 'N') {
            return;
        }
        try {
            teamSvc.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因："+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
