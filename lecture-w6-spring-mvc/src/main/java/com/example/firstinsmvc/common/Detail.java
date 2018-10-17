package com.example.firstinsmvc.common;

import com.example.firstinsmvc.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Detail {

  private String statusCode;

  private String message;

  private Member data;

}
