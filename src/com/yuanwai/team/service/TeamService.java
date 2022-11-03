package com.yuanwai.team.service;

import com.yuanwai.team.domain.Architect;
import com.yuanwai.team.domain.Employee;
import com.yuanwai.team.domain.Programmer;

import javax.management.Descriptor;

public class TeamService {
    private static int counter = 1;//给memberId赋值使用
    private final int MAX_MEMBER = 5;//限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员
    private int total;//记录开发团队中实际的人数


    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee employee) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if (isExist(employee)) {
            throw new TeamException("该成员已在开发团队中");
        }
        Programmer p = (Programmer) employee;
        if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该成员已是某团队成员");
        } else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
            throw new TeamException("该成员正在休假，无法添加");
        }
        int numOfArch = 0,numOfDes = 0, numOfPro = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Descriptor) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }

            if (p instanceof Architect) {
                if (numOfArch >= 1)
                    throw new TeamException("开发团队中至多只能有一名架构师");
                else if (p instanceof Descriptor)
                    if (numOfDes >= 2)
                        throw new TeamException("开发团队中至多只能有两名设计师");
                else if (p instanceof Programmer)
                    if (numOfPro >= 3)
                        throw new TeamException("开发团队中至多只能有三名程序员");
            }

            team[total++] = p;
            p.setStatus(Status.BUSY);
            p.setMemberId(counter++);


    }

    private boolean isExist(Employee employee) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == employee.getId()) return true;
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }
        for (int j = i+1; j < total; j++) {
            team[j - 1] = team[j];
        }
        team[--total] = null;

    }
}
