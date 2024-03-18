package com.tobeto.entity.type;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ram {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private int capacity;
	@Column(name = "frequency_speed")
	private int frequencySpeed;
	@Column(name = "channel_type")
	private String channelType;
	private String compatibility;
	private String brand;
	private String model;
}
