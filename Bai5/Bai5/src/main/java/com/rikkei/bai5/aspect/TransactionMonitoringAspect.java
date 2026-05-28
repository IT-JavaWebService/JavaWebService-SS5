package com.rikkei.bai5.aspect;

import com.rikkei.bai5.dto.TransactionRequest;
import com.rikkei.bai5.exception.HighRiskException;
import com.rikkei.bai5.exception.InvalidAddressException;
import com.rikkei.bai5.exception.InvalidAmountException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionMonitoringAspect {

    private static final Logger logger = LoggerFactory.getLogger(TransactionMonitoringAspect.class);

    @Before("execution(* com.rikkei.bai5.service.TransactionService.performTransaction(..)) && args(request)")
    public void validateTransaction(TransactionRequest request) {
        logger.info("[AOP Giám sát] Đang kiểm tra an toàn giao dịch gửi tới ví: {}", request.getWalletAddress());

        // 1. Kiểm tra số tiền gửi âm
        if (request.getAmount() <= 0) {
            throw new InvalidAmountException("Số tiền giao dịch không hợp lệ (phải lớn hơn 0).");
        }

        // 2. Kiểm tra địa chỉ ví nhận < 5 ký tự
        if (request.getWalletAddress() == null || request.getWalletAddress().length() < 5) {
            throw new InvalidAddressException("Địa chỉ ví nhận quá ngắn hoặc không hợp lệ.");
        }

        // 3. Kiểm tra rủi ro dòng tiền lớn hơn 10,000 USD
        if (request.getAmountInUsd() > 10000) {
            logger.warn("[AOP Cảnh báo] Giao dịch lớn vượt hạn mức tự động: {}$", request.getAmountInUsd());
            throw new HighRiskException("Giao dịch rủi ro cao vượt mức 10,000 USD. Yêu cầu duyệt thủ công.");
        }

        logger.info("[AOP Giám sát] Giao dịch an toàn. Chuyển tiếp tới xử lý nghiệp vụ.");
    }
}