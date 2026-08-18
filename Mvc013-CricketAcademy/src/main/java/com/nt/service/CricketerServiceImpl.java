package com.nt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.entity.Cricketer;
import com.nt.repository.CricketerRepository;

@Service
public class CricketerServiceImpl implements CricketerService {

	private final CricketerRepository repo;

	CricketerServiceImpl(CricketerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Cricketer saveCricketer(Cricketer cric) {
		return repo.save(cric);
	}

	@Override
	public List<Cricketer> getAllCricketers() {
		return repo.findAll();
	}

	@Override
	public Cricketer getCricketerById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Cricketer not found with ID: " + id));
	}

	@Override
	public Cricketer updateCricketer(Cricketer cric) {
		if (cric.getPlayerId() == null) {
			throw new IllegalArgumentException("Player ID required");
		}

		Cricketer existing = getCricketerById(cric.getPlayerId());

		existing.setPlayerName(cric.getPlayerName());
		existing.setTeamName(cric.getTeamName());
		existing.setRole(cric.getRole());
		existing.setBattingStyle(cric.getBattingStyle());
		existing.setJerseyNumber(cric.getJerseyNumber());

		return repo.save(existing);

	}

	@Override
	public void deleteCricketer(Integer id) {
		if (!repo.existsById(id)) {
			throw new IllegalArgumentException("Cricketer not found with ID: " + id);
		}
		repo.deleteById(id);
	}

}
