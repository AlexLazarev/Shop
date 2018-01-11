
CREATE TRIGGER before_producer_delete BEFORE DELETE ON Producer
  FOR EACH ROW BEGIN
  DELETE FROM Supply WHERE producer_id = OLD.id;
END;


CREATE TRIGGER before_supply_delete BEFORE DELETE ON Supply
FOR EACH ROW BEGIN
UPDATE Product SET supply_id=Null WHERE supply_id = OLD.id;
END;



