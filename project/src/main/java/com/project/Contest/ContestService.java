package com.project.Contest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContestService {


    @Autowired
    private ContestRepository contestRepository;

    //CRUD->SQl->HTTPRequest
    //create/insert/post
    public void addContest(Contest contest) {
        contestRepository.save(contest);
    }

    //read/select/get
    public List<Contest> getContests() {

        return contestRepository.findAll();
    }

    public Optional<Contest> getContest(long id) {
        Optional<Contest> user = contestRepository.findById(id);
        return user;
    }

    //update/update/put
    public void updateContest(Contest contest) {

        Optional<Contest> theUser = contestRepository.findById(contest.getId());

        theUser.map(contests0 -> {
            contests0.setName(contest.getName());
            contests0.setTeams(contest.getTeams());
            contests0.setUsers(contest.getUsers());
            return null;
        });


    }

    //delete/delete/delete
    public void deleteContest(Contest contest) {
        contestRepository.delete(contest);
    }


}
