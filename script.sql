SELECT cron.schedule(
               'cancel-pending-bank-transfer-reservations',
               '0 0 * * *',
               $$
    UPDATE room_reservation
    SET reservation_status = 'CANCELLED'
    WHERE payment_method = 'BANK_TRANSFER'
    AND payment_status = 'PENDING_PAYMENT'
    AND start_date = CURRENT_DATE + INTERVAL '2 days';
    $$
);